package com.jjurm.projects.mpp.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;

import com.jjurm.projects.mpp.model.Place;
import com.peertopark.java.geocalc.DegreeCoordinate;
import com.peertopark.java.geocalc.Point;

public class PlaceFinder {

  public static final String QUERY_BASE =
      "SELECT bigcities.id as id, bigcities.country as country, accent, lat, lon, tz_id, alt, temperature.*, precipitation.* "
          + "FROM bigcities LEFT JOIN countries ON (UPPER(bigcities.country) = countries.alpha2) "
          + "LEFT JOIN temperature ON (countries.alpha3 = temperature.country) LEFT JOIN precipitation ON (countries.alpha3 = precipitation.country) "
          + "WHERE tz_id is not null and bigcities.ign = 0";

  public static Place id(int id) throws NotFoundException, SQLException {
    return query("id = " + id);
  }

  public static Place city(String city) throws NotFoundException, SQLException {
    return query("city like '%" + city + "%'");
  }

  public static Place accent(String accent) throws NotFoundException, SQLException {
    return query("accent like '%" + accent + "%'");
  }

  public static Place fromResultSet(ResultSet result) throws SQLException {
    int id = result.getInt("id");
    String name = result.getString("accent");
    Point point = new Point(new DegreeCoordinate(result.getDouble("lat")),
        new DegreeCoordinate(result.getDouble("lon")));
    TimeZone timezone = TimeZone.getTimeZone(result.getString("tz_id"));
    int altitude = result.getInt("alt");

    double[] temperature = new double[13];
    temperature[0] = result.getDouble("tjan");
    temperature[1] = result.getDouble("tfeb");
    temperature[2] = result.getDouble("tmar");
    temperature[3] = result.getDouble("tapr");
    temperature[4] = result.getDouble("tmay");
    temperature[5] = result.getDouble("tjun");
    temperature[6] = result.getDouble("tjul");
    temperature[7] = result.getDouble("taug");
    temperature[8] = result.getDouble("tsep");
    temperature[9] = result.getDouble("toct");
    temperature[10] = result.getDouble("tnov");
    temperature[11] = result.getDouble("tdec");
    temperature[12] = result.getDouble("tannual");
    double[] precipitation = new double[13];
    precipitation[0] = result.getDouble("pjan");
    precipitation[1] = result.getDouble("pfeb");
    precipitation[2] = result.getDouble("pmar");
    precipitation[3] = result.getDouble("papr");
    precipitation[4] = result.getDouble("pmay");
    precipitation[5] = result.getDouble("pjun");
    precipitation[6] = result.getDouble("pjul");
    precipitation[7] = result.getDouble("paug");
    precipitation[8] = result.getDouble("psep");
    precipitation[9] = result.getDouble("poct");
    precipitation[10] = result.getDouble("pnov");
    precipitation[11] = result.getDouble("pdec");
    precipitation[12] = result.getDouble("pannual");

    Place place = new Place(id, name, point, timezone, altitude, temperature, precipitation);
    return place;
  }

  protected static Place query(String condition) throws NotFoundException, SQLException {
    String query = QUERY_BASE + " AND " + condition + " ORDER BY population DESC LIMIT 1";
    try (Connection conn = DatabaseManager.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(query)) {
      if (result.first()) {
        return fromResultSet(result);
      } else {
        throw new NotFoundException("Place not found (" + condition + ")");
      }
    }
  }

  public static class NotFoundException extends Exception {
    public NotFoundException(String s) {
      super(s);
    }
  }

}
