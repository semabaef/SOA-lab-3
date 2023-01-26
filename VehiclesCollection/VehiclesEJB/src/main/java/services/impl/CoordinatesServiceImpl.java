package services.impl;

import dao.CoordinatesDao;
import models.entities.Coordinates;
import org.jboss.ejb3.annotation.Pool;
import services.CoordinatesService;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
@Pool("slsb-strict-max-pool") // slsb-strict-max-pool по дефолту 16
public class CoordinatesServiceImpl implements CoordinatesService {


    @EJB
    private CoordinatesDao coordinatesDao;

    @Override
    public Coordinates checkAndSaveCoordinatesIfAreNotInBD(Coordinates coordinates) {
        Coordinates oldCoordinates = coordinatesDao.findByXAndY(coordinates.getX(), coordinates.getY());
        if (oldCoordinates == null) {
            coordinatesDao.save(coordinates);
            return coordinates;
        }
        return oldCoordinates;
    }

}
