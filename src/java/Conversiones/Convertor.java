/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conversiones;

import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.ResultSet;
import java.util.ArrayList;

 public class Convertor {
  
    public static String convertToJSON(ResultSet resultSet)
            throws Exception {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        while (resultSet.next()) {
            int total_filas = resultSet.getMetaData().getColumnCount();
            
            ArrayList filas = new ArrayList();
            for (int i = 0; i < total_filas; i++) {
                filas.add(resultSet.getObject(i+1));
            }
            ArrayList Column = new ArrayList();
            for (int i = 0; i < total_filas; i++) {
                Column.add(resultSet.getMetaData().getColumnLabel(i+1));
            }
           
                JSONObject obj = new JSONObject();
                
            for (int i = 0; i < total_filas; i++) {
                obj.put(Column.get(i).toString()
                        ,filas.get(i));
            }
                jsonArray.put(obj);               
                jsonObject.put("Table",jsonArray);
            }
        
        return jsonObject.toString();
    }

    public static String convertToXML(ResultSet resultSet)
            throws Exception {
        StringBuffer xmlArray = new StringBuffer("<results>");
        while (resultSet.next()) {
            int total_rows = resultSet.getMetaData().getColumnCount();
            xmlArray.append("<result ");
            for (int i = 0; i < total_rows; i++) {
                xmlArray.append(" " + resultSet.getMetaData().getColumnLabel(i + 1)
                .toLowerCase() + "='" + resultSet.getObject(i + 1) + "'"); }
            xmlArray.append(" />");
        }
        xmlArray.append("</results>");
        return xmlArray.toString();
    }

 }