package com.test.automation.project.testautomationjavaservicebackend.api.database;

import com.test.automation.project.testautomationjavaservicebackend.api.model.Car;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@NoArgsConstructor
public class CarsDAO {
    private final List<Car> carsDatabase = List.of(
            new Car("./assets/Images/BMW/cosySec(2).jpg", "BMW i3s Atelier", 187900000.0, "Electric engine", "BMW"),
            new Car("./assets/Images/BMW/cosySec(1).jpg", "BMW 330e iPerformance", 184900000.0, "Hybrid", "BMW"),
            new Car("./assets/Images/BMW/cosySec.jpg", "BMW M240i Cabrio", 179900000.0, "Combustion engine", "BMW"),
            new Car("./assets/Images/KIA/kiacerato.jpg", "Kia cerato", 97490000.0, "Combustion engine", "Kia"),
            new Car("./assets/Images/KIA/KIAStonic.jpg", "Kia Stonic", 76290000.0, "Hybrid", "Kia"),
            new Car("./assets/Images/KIA/KiaSportage.jpg", "Kia KiaSportage", 97490000.0, "Combustion engine", "Kia"),
            new Car("./assets/Images/Porsche/Taycan.jpeg", "Porsche Taycan", 770000000.0, "Electric engine", "Porsche"),
            new Car("./assets/Images/Porsche/Macan.jpeg", "Porsche MACAN", 549900000.0, "Combustion engine", "Porsche"),
            new Car("./assets/Images/Porsche/Cayenne.jpeg", "Porsche CAYENNE", 218780000.0, "Combustion engine", "Porsche")
    );
}
