package utils.validators;

import exceptions.ExceptionDescription;
import exceptions.RestApplicationException;
import models.enums.VehicleType;


public class CommonValidator {

    public static Long validateLong(String num) {
        Long res;
        if (num.isEmpty())
            throw new RestApplicationException(ExceptionDescription.INVALID_REQUEST_ARGUMENTS);
        try {
            res = Long.valueOf(num);
        } catch (Exception e) {
            throw new RestApplicationException(ExceptionDescription.INVALID_REQUEST_ARGUMENTS);
        }
        return res;
    }

    public static Integer validateInteger(String num) {
        Integer res;
        if (num.isEmpty())
            throw new RestApplicationException(ExceptionDescription.INVALID_REQUEST_ARGUMENTS);
        try {
            res = Integer.valueOf(num);
        } catch (Exception e) {
            throw new RestApplicationException(ExceptionDescription.INVALID_REQUEST_ARGUMENTS);
        }
        return res;
    }
    public static void validateVehicleType(String text) {
        try {
            Enum.valueOf(VehicleType.class, text);
        } catch (Exception e) {
            throw new RestApplicationException(ExceptionDescription.INVALID_REQUEST_ARGUMENTS);
        }
    }

    public static void validateString(String text) {
        if (text.isEmpty())
            throw new RestApplicationException(ExceptionDescription.INVALID_REQUEST_ARGUMENTS);
    }
}
