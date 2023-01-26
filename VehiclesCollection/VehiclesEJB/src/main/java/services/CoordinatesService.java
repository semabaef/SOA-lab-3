package services;


import models.entities.Coordinates;


public interface CoordinatesService {
    Coordinates checkAndSaveCoordinatesIfAreNotInBD(Coordinates coordinates);

}
