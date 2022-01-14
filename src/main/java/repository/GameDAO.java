package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Game;

public class GameDAO {
	
    private DataSource ds;
    	
    public GameDAO(DataSource ds) throws SQLException {
        this.ds = ds;
    }


    public List<Game> getGames() throws SQLException {
        List<Game> games = new ArrayList<Game>();
        String sql = "SELECT gameid, gamename, category, age, price, gamepic FROM game";
        try (Connection conn = ds.getConnection()){
            try(PreparedStatement pstm = conn.prepareStatement(sql);
                       ResultSet rs = pstm.executeQuery()){
                while(rs.next()) {
                    Game m = new Game(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getString(6));
                    games.add(m);
                }
            }
        }
        return games;
    }


    public Game getGame(int gameid) throws SQLException {
        Game agame = null;
        String sql = "SELECT gameid, gamename, category, age, price, gamepic FROM game WHERE gameid=?";
        try (Connection conn = ds.getConnection()){
            try(PreparedStatement pstm = conn.prepareStatement(sql)){
                pstm.setInt(1, gameid);
                try(ResultSet rs = pstm.executeQuery()){
                    if (rs.next()) {
                        agame = new Game(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getString(6));
                    }
                }
            }
        }
        return agame;
    }


    public int insertGame(Game agame) throws SQLException {
        String sql = "INSERT INTO game(gamename, category, age, price, gamepic) VALUES(?, ?, ?, ?, ?)";
        int gameid = 0;
        try (Connection conn = ds.getConnection()){
            try(PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                pstm.setString(1, agame.getGamename());
                pstm.setString(2, agame.getCategory());
                pstm.setBigDecimal(3, agame.getAge());
                pstm.setBigDecimal(4, agame.getPrice());
                pstm.setString(5, agame.getGamepic());
                pstm.executeUpdate();				
                try(ResultSet rs = pstm.getGeneratedKeys()){
                    if (rs.next()) {
                        gameid = rs.getInt(1);
                    }	
                }					
            }
        }
        return gameid;
    }

	public Game find(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}	
}