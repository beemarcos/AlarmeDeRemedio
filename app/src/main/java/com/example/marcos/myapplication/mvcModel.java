final class mvcModel{
  private static final String DB_NAME = "drogas";
  private static final String TABLE_NAME = "remedio";
  private static final int DB_VERSION = 1;
  private static final String DB_CREATE_QUERY = "CREATE TABLE "+mvcModel.TABLE_NAME+"("+
    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
    "nome TEXT,"+
    "descricao TEXT,"+
    "tipo_dosagem TEXT"+
    "dosagem INTEGER,"+
    ");";
}
