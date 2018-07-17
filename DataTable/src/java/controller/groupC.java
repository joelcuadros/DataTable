package controller;

import dao.groupDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.Data;
import model.groupModel;

@Named(value = "groupC")
@SessionScoped
@Data
public class groupC implements Serializable {

    groupDao dao = new groupDao();
    List<groupModel> lstgroup;

    @PostConstruct
    public void start() {
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void listar() throws Exception {
        try {
            lstgroup = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

}
