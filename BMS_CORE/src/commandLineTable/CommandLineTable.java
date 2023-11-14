package commandLineTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CommandLineTable {
    private static final String HORIZONTAL_SEP = "-";
    private String verticalSep;
    private String joinSep;
    private String[] headers;
    private List<String[]> rows = new ArrayList<>();
    private boolean rightAlign;

    public CommandLineTable() {
        setShowVerticalLines(false);
    }

    public void setRightAlign(boolean rightAlign) {
        this.rightAlign = rightAlign;
    }

    public void setShowVerticalLines(boolean showVerticalLines) {
        verticalSep = showVerticalLines ? "|" : "";
        joinSep = showVerticalLines ? "+" : " ";
    }

    public void setHeaders(String... headers) {
        this.headers = headers;
    }

    public void addRow(String... cells) {
        rows.add(cells);
    }

    public void print() {
        int[] maxWidths = headers != null ?
                Arrays.stream(headers).mapToInt(String::length).toArray() : null;

        for (String[] cells : rows) {
            if (maxWidths == null) {
                maxWidths = new int[cells.length];
            }
            if (cells.length != maxWidths.length) {
                throw new IllegalArgumentException("Number of row-cells and headers should be consistent");
            }
            for (int i = 0; i < cells.length; i++) {
                maxWidths[i] = Math.max(maxWidths[i], cells[i].length());
            }
        }

        if (headers != null) {
            printLine(maxWidths);
            printRow(headers, maxWidths);
            printLine(maxWidths);
        }
        for (String[] cells : rows) {
            printRow(cells, maxWidths);
        }
        if (headers != null) {
            printLine(maxWidths);
        }
    }

    private String printLine(int[] columnWidths) {
    	String printLine = "";
        for (int i = 0; i < columnWidths.length; i++) {
            String line = String.join("", Collections.nCopies(columnWidths[i] +
                    verticalSep.length() + 1, HORIZONTAL_SEP));
            printLine += String.format(joinSep + line + (i == columnWidths.length - 1 ? joinSep : ""));
        }
       return printLine;
    }
    
    private void printRow(String[] cells, int[] maxWidths) {
    	String rowTemp = "";
        for (int i = 0; i < cells.length; i++) {
            String s = cells[i];
            String verStrTemp = i == cells.length - 1 ? verticalSep : "";
            if (rightAlign) {
                System.out.printf("%s %" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            } else {
            	rowTemp += String.format("%s %-" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            }
        }
        System.out.println(rowTemp);
    }

    public static void main(String[] args) {
        //test code
        CommandLineTable st = new CommandLineTable();
        //st.setRightAlign(true);//if true then cell text is right aligned
        st.setShowVerticalLines(true);//if false (default) then no vertical lines are shown
        st.setHeaders("one", "two", "three");//optional - if not used then there will be no header and horizontal lines
        st.addRow("super", "broccoli", "flexible");
        st.addRow("assumption", "announcement", "reflection");
        st.addRow("logic", "pleasant", "wild");
        st.print();
    }

	public StringBuilder printWithColors(String color) {
    	StringBuilder out = new StringBuilder();
    	
    	if(rows.isEmpty()){
    		return null;
    	}
        int[] maxWidths = headers != null ?
                Arrays.stream(headers).mapToInt(String::length).toArray() : null;

        for (String[] cells : rows) {
            if (maxWidths == null) {
                maxWidths = new int[cells.length];
            }
            if (cells.length != maxWidths.length) {
                throw new IllegalArgumentException("Number of row-cells and headers should be consistent");
            }
            for (int i = 0; i < cells.length; i++) {
            	if(cells[i] == null){
            		cells[i] = "N/A";
            	}
            	int length = cells[i].length();
            	if(cells[i].contains(color)) {
            		length = length - (color.length() + ConsoleColours.RESET.length());
            	}
                maxWidths[i] = Math.max(maxWidths[i], length);
            }
        }
        if (headers != null) {
        	out.append(printLine(maxWidths)+"\n");
        	out.append(printRowWithColors(headers, maxWidths, color)+"\n");
        	out.append(printLine(maxWidths)+"\n");
        }
        for (String[] cells : rows) {
        	out.append(printRowWithColors(cells, maxWidths, color)+"\n");
        }
        if (headers != null) {
        	out.append(printLine(maxWidths)+"\n");
        }
        return out;
    }

	 private String printRowWithColors(String[] cells, int[] maxWidths, String color) {
    	String rowTemp = "";
        for (int i = 0; i < cells.length; i++) {
            String s = cells[i];
            String verStrTemp = i == cells.length - 1 ? verticalSep : "";
            if (rightAlign) {
                System.out.printf("%s %" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            } else {
            	int maxWidth = maxWidths[i];
            	if(cells[i].contains(color)) {
            		maxWidth = maxWidth + (color.length() + ConsoleColours.RESET.length());
            	}
            	rowTemp += String.format("%s %-" + maxWidth + "s %s", verticalSep, s, verStrTemp);
            }
        }
        return rowTemp;
    }
}