package org.example.DAO;

import org.example.DTO.Circuit;
import org.example.Exceptions.DaoException;

import java.util.ArrayList;
import java.util.List;

public class MySqlCircuitDao extends MySqlDao implements CircuitDaoInterface
{
    @Override
    public List<Circuit> getAllCircuits() throws DaoException {
        return SQLConnectionDecorator(
                (sql) -> {
                    List<Circuit> output = new ArrayList<>();
                    String query = "SELECT * FROM Circuits";
                    sql.statement = sql.connection.prepareStatement(query);
                    sql.result = sql.statement.executeQuery();
                    Circuit next;
                    while(sql.result.next())
                    {
                        next = new Circuit(
                                sql.result.getInt("id"),
                                sql.result.getString("circuit_name"),
                                sql.result.getString("country"),
                                sql.result.getFloat("length"),
                                sql.result.getInt("turns")
                        );
                        output.add(next);
                    }
                    return output;
                }
        );
    }
}


