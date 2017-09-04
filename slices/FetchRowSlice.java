import org.acme.database.Book;
import org.acme.database.Booklist;
import org.acme.database.Cursor;
import org.acme.database.Database;
import org.acme.database.ConnectionException;

import java.util.ArrayList;
import java.util.List;


public class FetchRowSlice {

    public static void main(String[] args) throws ConnectionException {
        String QUERY = "SELECT id, title, year, num_pages FROM table WHERE title LIKE '%" + "romance" + "%'";
        int COLUMN_INDEX_TITLE = 1;
        Database database = new Database("lou", "PA$$W0RD", "https://acme-books.com/db");
        Cursor cursor = database.cursor();
        cursor.execute(QUERY);
        boolean finished = false;
        if (cursor.rowCount() > 0) {
            int rowNumber = 0;
            while (!finished) {
                int rowCount = cursor.rowCount();
                for (int i = 0; i < Math.min(rowCount, maxBooks); ++i) {
                    cursor.fetchone();
                    String title = cursor.getString(COLUMN_INDEX_TITLE);
                    rowNumber++;
                    if (cursor.end() || rowNumber >= maxBooks) {
                        finished = true;
                    } else if (i == rowCount - 1){
                        cursor.next(id);
                    }
                }
             }
        }
    }

}
