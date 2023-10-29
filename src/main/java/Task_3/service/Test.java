package Task_3.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@Transactional
public class Test {

    final CarService carService;

    public Test(CarService carService) {
        this.carService = carService;
    }

    @PostConstruct
    private void test() {
        System.out.println(carService.getAllCars());
    }
}
