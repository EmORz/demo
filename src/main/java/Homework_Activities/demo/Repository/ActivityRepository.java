package Homework_Activities.demo.Repository;

import Homework_Activities.demo.Entity.Activity;
import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository<Activity, Long> {
}
