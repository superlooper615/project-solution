package edu.uh.tech.cis3368.semesterproject;

import edu.uh.tech.cis3368.semesterproject.employees.EmployeeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class MainController {

    @FXML
    private Button btnManageEmployees;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    public void doManageEmployees(ActionEvent actionEvent) throws IOException {
        Stage parent  = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("employees/employees.fxml"));
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(fxmlLoader.load());
        EmployeeController employeeController = fxmlLoader.getController();
        employeeController.setReturnScene(btnManageEmployees.getScene());
        parent.setScene(scene);


    }

    public void doCreateJobs(ActionEvent actionEvent) throws IOException {
        Stage parent  = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("jobs.fxml"));
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(fxmlLoader.load());
        JobController jobController = fxmlLoader.getController();
        jobController.setReturnScene(btnManageEmployees.getScene());
        parent.setScene(scene);
    }
}
