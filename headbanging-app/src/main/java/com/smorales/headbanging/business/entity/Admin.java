package com.smorales.headbanging.business.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "admin")
@DiscriminatorValue("ADMIN")
@PrimaryKeyJoinColumn(name = "admin_id", referencedColumnName = "user_id")
@NamedQueries({
        @NamedQuery(name = Admin.findAll, query = "Select a from Admin a")
})
public class Admin extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PREFIX = "Admin";
    public static final String findAll = PREFIX + ".findAll";

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "admin_info")
    private String adminInfo;

    public String getAdminInfo() {
        return adminInfo;
    }

    public void setAdminInfo(String adminInfo) {
        this.adminInfo = adminInfo;
    }
}
