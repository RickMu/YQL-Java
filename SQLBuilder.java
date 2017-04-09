/**
 * Created by 高静 on 2017/4/9.
 */
public class SQLBuilder {
    static String SELECT_ALL = "SELECT * FROM ";
    static String FILTER =" WHERE Symbol ";

    private String parseSymbols(String[] symbols){
        String sym="";
        for(int i =0 ;i<symbols.length-1;i++){
            sym+=symbols[i]+",";
        }
        sym+=symbols[symbols.length-1];
        sym = "("+sym+")";
        return sym;
    }

}
