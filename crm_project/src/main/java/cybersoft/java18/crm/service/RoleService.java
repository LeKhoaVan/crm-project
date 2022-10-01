package cybersoft.java18.crm.service;

import cybersoft.java18.crm.model.RoleModel;
import cybersoft.java18.crm.repository.RoleRepository;

import java.util.List;

public class RoleService {
    private static RoleService INSTANCE = null;
    private final RoleRepository roleRepository;

    private RoleService() {
        roleRepository = new RoleRepository();
    }

    public static RoleService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RoleService();
        }
        return INSTANCE;
    }


    public List<RoleModel> getAllRole() {
        return roleRepository.getAllRole();
    }

    public int deleteById(String id) {
        return roleRepository.executeDeleteById(id);
    }

    public int updateById(RoleModel roleModel) {
        return roleRepository.executeUpdate(roleModel);
    }

    public int createRole(String roleName, String description) {
        return roleRepository.executeCreateRole(roleName, description);
    }
}
