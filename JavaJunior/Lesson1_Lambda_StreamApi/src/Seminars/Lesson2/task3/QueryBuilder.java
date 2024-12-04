package Seminars.Lesson2.task3;

import java.lang.reflect.Field;
import java.util.UUID;

public class QueryBuilder {

    public String buildInsertQuery(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        StringBuilder query = new StringBuilder("INSERT INTO ");

        if (clazz.isAnnotationPresent(Table.class)){
            Table tableAnnatation = clazz.getAnnotation(Table.class);
            query.append(tableAnnatation.name())
                    .append(" (");

            Field[] fields = clazz.getDeclaredFields();
            for (Field field:fields){
                if(field.isAnnotationPresent(Column.class)){
                    Column columnAnotation = field.getAnnotation(Column.class);
                    query.append(columnAnotation.name()).append(", ");
                }
            }
            if (query.charAt(query.length() - 2) == ',') {
                query.delete(query.length() - 2, query.length());
            }

            query.append(") VALUE(");

            for (Field field:fields){
                if(field.isAnnotationPresent(Column.class)){
                    field.setAccessible(true);
                    query.append("'").append(field.get(obj)).append("', ");
                }
            }
            if (query.charAt(query.length() - 2) == ',') {
                query.delete(query.length() - 2, query.length());
            }
            query.append(")");
            return query.toString();
        }
        else {
            return null;
        }
    }



    public  String buildSelectQuery(Class<?> clazz, UUID primaryKey) {
        StringBuilder query = new StringBuilder("SELECT * FROM ");

        if (clazz.isAnnotationPresent(Table.class)) {
            Table tableAnnatation = clazz.getAnnotation(Table.class);
            query.append(tableAnnatation.name())
                    .append(" WHERE ");
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column columnAnotation = field.getAnnotation(Column.class);
                if (columnAnotation.primaryKey()) {
                    query.append(columnAnotation.name()).append(" =").append(primaryKey);
                    break;
                }
            }
        }
        return query.toString();
    }

    public String buildUpdateQuery(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        StringBuilder query = new StringBuilder("UPDATE ");

        if (clazz.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = clazz.getAnnotation(Table.class);
            query.append(tableAnnotation.name()).append(" SET ");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)){
                    field.setAccessible(true);
                    Column columnAnantation = field.getAnnotation(Column.class);
                    if (columnAnantation.primaryKey())
                        continue;
                    query.append(columnAnantation.name()).append(" = '").append(field.get(obj)).append("', ");
                }

            }
            if (query.charAt(query.length() - 2) == ',') {
                query.delete(query.length() - 2, query.length());
            }

            query.append(" WHERE ");
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)){
                    field.setAccessible(true);
                    Column columnAnantation = field.getAnnotation(Column.class);
                    if (columnAnantation.primaryKey()){
                        query.append(columnAnantation.name()).append(" = '").append(field.get(obj)).append("'");
                        break;
                    }
                }

            }
            return query.toString();

        } else {
            return null;
        }

    }
}
