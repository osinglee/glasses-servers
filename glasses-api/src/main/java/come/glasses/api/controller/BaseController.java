package come.glasses.api.controller;

import come.glasses.entity.User;
import come.glasses.serviceImpl.AuthServiceImpl;
import come.glasses.utils.controller.APIController;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2020-01-13 09:29
 */
public class BaseController extends APIController {
    public BaseController(){}

    final User currentUser(){
        return AuthServiceImpl.getCurrentAuth();
    }
}
