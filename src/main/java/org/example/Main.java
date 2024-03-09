package org.example;

import org.example.DAO.CircuitDaoInterface;
import org.example.DAO.MySqlCircuitDao;
import org.example.DTO.Circuit;
import org.example.Exceptions.DaoException;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        CircuitDaoInterface ICircuitDao = new MySqlCircuitDao();

        try
        {
            System.out.println("\nCall getAllCircuits()");
            List<Circuit> circuits = ICircuitDao.getAllCircuits();     // call a method in the DAO
            for (Circuit circuit : circuits)
                System.out.println("Circuit: " + circuit.toString());
        }
        catch(DaoException e)
        {
            e.printStackTrace();
        }
    }
}