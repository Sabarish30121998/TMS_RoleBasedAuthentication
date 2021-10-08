package com.example.TMS.Controller;

import com.example.TMS.BaseResponse.BaseResponse;
import com.example.TMS.DTO.RoleDTO;
import com.example.TMS.EntityORModel.Role;
import com.example.TMS.Repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;


@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleRepo roleRepo;

    @PostMapping("/create")
    public BaseResponse create(@RequestBody RoleDTO roleDTO)
    {
        BaseResponse baseResponse= new BaseResponse();
        Role role= new Role();
        role.setRoleName(roleDTO.getRoleName());

        role=roleRepo.save(role);

        baseResponse.setStatuscode("success");
        baseResponse.setStatusmessage("Role is Successfully inserted");
        baseResponse.setData(role);
        return baseResponse;
    }

}
