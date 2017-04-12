package com.jjurm.projects.mpp.map;

import java.util.Date;

import com.jjurm.projects.mpp.model.Attendant;
import com.jjurm.projects.mpp.model.Parameters.ParametersList;
import com.jjurm.projects.mpp.model.Place;

/**
 * A map that lowers the productivity if the place is not the home of the attendant.
 * 
 * @author JJurM
 */
public class IsHomeMap extends ProductivityMap {

  public static final String PARAM_P = "P";

  public IsHomeMap(ParametersList parameters, Date date, Attendant attendant) {
    super(parameters, date, attendant);
  }

  @Override
  public double calculateProductivity(Place destination, int day) {
    return attendant.getOrigin().equals(destination) ? 1 : parameters.get(PARAM_P);
  }

}
