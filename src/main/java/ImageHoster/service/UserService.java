package ImageHoster.service;

import ImageHoster.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void registerUser(User user) {
        return;

    }

    public boolean login(User user) {
        if(user.getUsername().equals("upgrad") && user.getPassword().equals("password")) {
            return true;
        }
        else {
            return false;
        }
    }
}
