package cybersoft.java18.crm.service;

import cybersoft.java18.crm.model.UserModel;
import cybersoft.java18.crm.repository.UserRepository;

import java.util.List;

public class UserService {
    private static UserService INSTANCEUSER = null;
    private final UserRepository repository;

    private UserService() {
        this.repository = new UserRepository();
    }

    public static UserService getInstanceUser() {
        if (INSTANCEUSER == null) {
            return INSTANCEUSER = new UserService();
        }
        return INSTANCEUSER;
    }

    public List<UserModel> findAllUser() {
        return repository.getUser();
    }
}
