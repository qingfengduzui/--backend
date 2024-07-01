package org.example.test_second.service;

import io.swagger.annotations.Api;
import org.example.test_second.dto.ApiResult;
import org.example.test_second.pojo.*;
import org.example.test_second.pojo.table.account;

public interface IAuthService {

    result login(LoginInfo loginInfo);

    result logout(LoginInfo loginInfo);

    result register(RegisterInfo registerInfo);

    result update(updateAccount updateaccount);

    result updateheadpicture(headpicture headpicture);

    result selectcity(selectsimiliar selectsimiliar);

    result selectinterests(selectsimiliar selectsimiliar);

    result selectdormitory(selectsimiliar selectsimiliar);

    result sendverfication(verficationCode verficationCode);

    result updatepassword(updatepassword updatepassword);

    result sendverficationpassword(verficationCode verficationCode);
}
