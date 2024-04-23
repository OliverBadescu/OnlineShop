import admin.model.Admin;
import admin.service.AdminService;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AdminServiceTests {

    private AdminService adminService;

    @Test

    public void GivenAvailableUserAndPasswordCheckLogin(){

        ArrayList<Admin> admins = new ArrayList<>();
        Admin admin = new Admin(1, "test", "123");
        admins.add(admin);
        adminService= new AdminService(admins);

        Admin test1 = adminService.login("test", "123");
        Admin test2 = adminService.login("test", "456");


        assertEquals(admin, test1);
        assertEquals(null, test2);

    }

    @Test

    public void GivenAvailableIdCheckFound(){

        ArrayList<Admin> admins = new ArrayList<>();
        Admin admin = new Admin(1, "test", "123");
        admins.add(admin);
        adminService= new AdminService(admins);

        Admin test1 = adminService.findAdminById(1);
        Admin test2 = adminService.findAdminById(2);

        assertEquals("test", test1.getUser());
        assertEquals("123", test1.getPassword());
        assertEquals(null, test2);
    }

    @Test

    public void GivenAvailableAdminCheckIfGetsAdded(){

        ArrayList<Admin> admins = new ArrayList<>();
        Admin admin = new Admin(1, "test", "123");
        admins.add(admin);
        adminService= new AdminService(admins);

        Admin test = new Admin(3, "test", "456");
        Admin test1 = new Admin(2, "test2", "456");

        adminService.adaugareAdmin(test);
        adminService.adaugareAdmin(test1);

        assertEquals("test2", adminService.findAdminById(2).getUser());
        assertEquals(null, adminService.findAdminById(3));

    }



}
