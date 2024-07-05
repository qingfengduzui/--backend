package org.example.test_second.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.example.test_second.dto.ApiResult;
import org.example.test_second.mapper.accountMapper;
import org.example.test_second.pojo.*;
import org.example.test_second.pojo.table.account;
import org.example.test_second.pojo.table.chatotm;
import org.example.test_second.pojo.table.exchangedormitory;
import org.example.test_second.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
/**
 * 日志输出
 * log.debug("调试")
 * log.info("普通信息")
 * log.warn(“警告”)
 * log.error("错误")
 */
@RestController //绑定HTTP响应体和返回，HTTP参数和方法参数
@RequestMapping("auth") //类中的所有处理方法都将继承这个基础路径
@Api(tags = "用户登录信息接口")
public class AuthController {
    public final AuthServiceImpl authService;

    @Autowired //将依赖关系自动注入到类中
    public AuthController(AuthServiceImpl authService) {
        this.authService = authService;
    }

    @Autowired
    private accountMapper accountmapper;

    @ApiOperation(value = "用户登录接口")
    @PostMapping("/login") //声明和处理HTTP POST请求
    public result login(@RequestBody @ApiParam(value = "登录所需信息") LoginInfo loginInfo) {
        return authService.login(loginInfo);
    }

    @GetMapping("getAllById")
    @ApiOperation(value = "根据学号获取用户全部信息")
    public result getAllByStudentid(@RequestParam("id") Integer id)
    {
        return authService.getAllByStudentid(id);
    }

    @PostMapping("applyExchangeDormitory")
    @ApiOperation(value = "更换宿舍申请")
    public result applyexchangedormitory(@RequestBody exchangedormitory exchangedormitory)
    {
        result res = new result();
        try {
            String studentid = exchangedormitory.getStudentid();
            String name = exchangedormitory.getName();
            String olddormitory = exchangedormitory.getOlddormitory();
            String newdormitory = exchangedormitory.getNewdormitory();
            String major = exchangedormitory.getMajor();
            String reason = exchangedormitory.getReason();
            accountmapper.insertintoexchangedormitory(studentid,name,olddormitory,newdormitory,major,reason);
            res.setStatus(true);
            res.setResult("提交成功");
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }

    @PostMapping("/logout")
    @ApiOperation(value = "注销用户接口")
    public result logout(@RequestBody LoginInfo loginInfo) { return authService.logout(loginInfo); }

    @PostMapping("/register")
    @ApiOperation("注册接口")
    public result register(@RequestBody RegisterInfo registerInfo)
    {
        return authService.register(registerInfo);
    }

    @PostMapping("/update")
    @ApiOperation("更新个人信息接口")
    public result update(@RequestBody updateAccount updateaccount) {

        return authService.update(updateaccount);
    }

    @PostMapping("/updateheadpicture")
    @ApiOperation("更新头像")
    public result updateheadpicture(@RequestBody headpicture headpicture)
    {
        return authService.updateheadpicture(headpicture);
    }

    @ApiOperation("获取用户被点赞数")
    @GetMapping("/getUserFavor")
    public result getuserfavor(@RequestParam("id") int id)
    {
        System.out.println(1);
        result res = new result();
        res.setStatus(true);
        res.setResult(authService.getuserfavor(id));
        return res;
    }

    @PostMapping("/updatepassword")
    @ApiOperation("更新密码")
    public result updatepassword(@RequestBody updatepassword updatepassword)
    {
        return authService.updatepassword(updatepassword);
    }

    @PostMapping("/selectcity")
    @ApiOperation("选择相同城市学生")
    public result selectcity(@RequestBody selectsimiliar selectsimiliar)
    {
        return authService.selectcity(selectsimiliar);
    }

    @PostMapping("/selectinterests")
    @ApiOperation("选择相同兴趣学生")
    public result selectinterests(@RequestBody selectsimiliar selectsimiliar)
    {
        return authService.selectinterests(selectsimiliar);
    }

    @PostMapping("/selectdormitory")
    @ApiOperation("相同宿舍学生")
    public result selectdormitory(@RequestBody selectsimiliar selectsimiliar)
    {
        return authService.selectdormitory(selectsimiliar);
    }

    @PostMapping("/sendVerfication")
    @ApiOperation("注册发送验证码")
    public result sendVerfication(@RequestBody verficationCode verficationCode)
    {
        return authService.sendverfication(verficationCode);
    }

    @PostMapping("/sendVerficationpassword")
    @ApiOperation("更新密码发送验证码")
    public result sendVerficationpassword(@RequestBody verficationCode verficationCode)
    {
        return authService.sendverficationpassword(verficationCode);
    }


    @GetMapping("countDormitory")
    @ApiOperation("统计未住满的宿舍")
    public List<countDormitory> countdormitory()
    {
        List<countDormitory> chu = accountmapper.getcountdormitory();
        List<countDormitory> filteredChu = chu.stream()
                .filter(dormitory -> dormitory.getCount() < 4)
                .collect(Collectors.toList());
        return filteredChu;
    }


    @PostMapping("/uploadImage")
    @ApiOperation("上传图片")
    public String uploadImage(@RequestParam("image") MultipartFile file, @RequestParam("studentId") String studentId) {
//    public String uploadImage(@RequestBody uploadImage uploadimage) {
//        MultipartFile file = uploadimage.getFile();
//        String studentId = uploadimage.getStudentId();
        if (file.isEmpty()) {
            return "Image file is empty";
        }

        try {
            byte[] bytes = file.getBytes();
            String filename = file.getOriginalFilename();
            File destinationFile = new File("C:\\Users\\王旭博\\Desktop\\test_one\\picture\\", filename+".png"); // 指定存储路径

            // 确保目录存在
            if (!destinationFile.getParentFile().exists()) {
                destinationFile.getParentFile().mkdirs();
            }

            // 保存文件
            Files.write(destinationFile.toPath(), bytes);
            String imagePath = destinationFile.getAbsolutePath();
            Integer i = accountmapper.storageimage(imagePath, studentId);
            return "Image file is saved successfully: " + destinationFile.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to save image file: " + e.getMessage();
        }
    }

    @GetMapping("/getImage")
    @ApiOperation("获取图片")
    public ResponseEntity<Resource> getImage(@RequestParam("studentId") String studentId) {
        try {
            String imagePath = accountmapper.getImage(studentId);
            if (imagePath == null || imagePath.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            Path filePath = Paths.get(imagePath);
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType("image/png")) // 注意根据实际图片类型修改
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping("/getImageById")
    @ApiOperation("获取图片通过id号")
    public ResponseEntity<Resource> getImage(@RequestParam("id") Integer id) {
        try {
            String imagePath = accountmapper.getImagebyId(id);
            if (imagePath == null || imagePath.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            Path filePath = Paths.get(imagePath);
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType("image/png")) // 注意根据实际图片类型修改
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @PostMapping("/uploadbackground")
    @ApiOperation("上传背景")
    public String uploadbackground(@RequestParam("image") MultipartFile file, @RequestParam("studentId") String studentId) {
//    public String uploadImage(@RequestBody uploadImage uploadimage) {
//        MultipartFile file = uploadimage.getFile();
//        String studentId = uploadimage.getStudentId();
        if (file.isEmpty()) {
            return "Image file is empty";
        }

        try {
            byte[] bytes = file.getBytes();
            String filename = file.getOriginalFilename();
            File destinationFile = new File("C:\\Users\\王旭博\\Desktop\\test_one\\background\\", filename+".png"); // 指定存储路径

            // 确保目录存在
            if (!destinationFile.getParentFile().exists()) {
                destinationFile.getParentFile().mkdirs();
            }

            // 保存文件
            Files.write(destinationFile.toPath(), bytes);
            String imagePath = destinationFile.getAbsolutePath();
            Integer i = accountmapper.storagebackground(imagePath, studentId);
            return "Image file is saved successfully: " + destinationFile.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to save image file: " + e.getMessage();
        }
    }

    @GetMapping("/getbackground")
    @ApiOperation("获取背景")
    public ResponseEntity<Resource> getbackground(@RequestParam("id") Integer id) {
        try {
            System.out.println(1);
            String imagePath = accountmapper.getbackground(id);
            if (imagePath == null || imagePath.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            Path filePath = Paths.get(imagePath);
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType("image/png")) // 注意根据实际图片类型修改
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/uploadjingxuanpic")
    @ApiOperation("上传精选照片")
    public String uploadjingxuanpic(@RequestParam("image") MultipartFile file, @RequestParam("studentId") String studentId) {
//    public String uploadImage(@RequestBody uploadImage uploadimage) {
//        MultipartFile file = uploadimage.getFile();
//        String studentId = uploadimage.getStudentId();
        if (file.isEmpty()) {
            return "Image file is empty";
        }

        try {
            byte[] bytes = file.getBytes();
            String filename = file.getOriginalFilename();
            File destinationFile = new File("C:\\Users\\王旭博\\Desktop\\test_one\\jingxuanpic\\", filename+".png"); // 指定存储路径

            // 确保目录存在
            if (!destinationFile.getParentFile().exists()) {
                destinationFile.getParentFile().mkdirs();
            }

            // 保存文件
            Files.write(destinationFile.toPath(), bytes);
            String imagePath = destinationFile.getAbsolutePath();
            Integer i = accountmapper.storagejingxuanpic(imagePath, studentId);
            return "Image file is saved successfully: " + destinationFile.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to save image file: " + e.getMessage();
        }
    }

    @GetMapping("/getjingxuanpic")
    @ApiOperation("获取精选照片")
    public ResponseEntity<Resource> getjingxuanpic(@RequestParam("id") Integer id) {
        try {
            System.out.println(1);
            String imagePath = accountmapper.getjingxuanpic(id);
            if (imagePath == null || imagePath.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            Path filePath = Paths.get(imagePath);
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType("image/png")) // 注意根据实际图片类型修改
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/upqqsign")
    @ApiOperation("上传qq签名")
    public result upqqsign(@RequestParam("id") Integer id, @RequestParam("qqsign") String qqsign)
    {
        result res = new result();
        try {
            Integer i = accountmapper.upqqsign(id, qqsign);
            if(i.equals(1)){
                res.setStatus(true);
                res.setResult("上传成功");
                return res;
            } else {
                res.setStatus(false);
                res.setResult("上传失败");
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }

    @ApiOperation("获取qq签名")
    @GetMapping("/getqqsign")
    public result getqqsign(@RequestParam("id") Integer id)
    {
        result res = new result();
        try {
            String qqsign1 = accountmapper.getqqsign(id);

                res.setStatus(true);
                res.setResult(qqsign1);
                return res;
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }



}
