package takeout.mainweb.Service;

import takeout.mainweb.component.ResponseResult;

public interface LoginService {
    ResponseResult login(String name, String pwd);
}
