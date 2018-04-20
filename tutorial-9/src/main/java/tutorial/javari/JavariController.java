package tutorial.javari;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tutorial.javari.animal.Animal;
import tutorial.javari.exceptions.EmptyZooException;
import tutorial.javari.exceptions.NoSuchID;

import java.util.ArrayList;

@RestController
@RequestMapping("/javari")
public class JavariController {

    private JavariBackend model = new JavariBackend();

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<Animal> getAll() {
        if (model.animalCount() > 0) {
            return model.wholeZoo();
        }
        else {
            throw new EmptyZooException();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Animal getAnimal(@PathVariable("id") int id) {
        if (model.animalCount() == 0) {
            throw new EmptyZooException();
        }
        if (model.idExists(id)) {
            return model.getAnimal(id);
        }
        else {
            throw new NoSuchID();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Animal removeAnimal(@PathVariable("id") int id) {
        if (model.animalCount() == 0) {
            throw new EmptyZooException();
        }
        if (model.idExists(id)) {
            return model.removeAnimal(id);
        }
        else {
            throw new NoSuchID();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Animal addAnimal(@RequestBody String JSONformat) {
        return model.addAnimal(JSONformat);
    }

}
