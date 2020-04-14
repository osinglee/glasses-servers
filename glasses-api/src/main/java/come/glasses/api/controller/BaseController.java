package come.glasses.api.controller;

import come.glasses.entity.UserEntity;
import come.glasses.serviceImpl.AuthServiceImpl;
import come.glasses.utils.controller.APIController;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2020-01-13 09:29
 */
public class BaseController extends APIController {
    public BaseController(){}

    final UserEntity currentUser(){
        return AuthServiceImpl.getCurrentAuth();
    }
}
