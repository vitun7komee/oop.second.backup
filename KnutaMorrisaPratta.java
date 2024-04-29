import java.util.LinkedList;

class KnutaMorrisaPratta extends Template {
    
    @Override
    protected boolean step1(String string, String substring)
    {
        LinkedList<Integer> prefixResult = step3(string, substring);
        //System.out.println(prefixResult);
        return !prefixResult.isEmpty();
    }

    private LinkedList<Integer> step2(String string) {
        LinkedList<Integer> borders = new LinkedList<Integer>();
        for (int i = 0; i < string.length(); i++) {
            borders.add(0);
        }
        int border = 0;
        for (int i = 1; i < string.length(); i++)
        {
            while (border > 0 && string.charAt(i) != string.charAt(border))
                border = borders.get(border - 1);

            if (string.charAt(i) == string.charAt(border))
                border++;

            borders.set(i, border);
        }
        return borders;
    }

    private LinkedList<Integer> step3(String string, String substring)
    {
        LinkedList<Integer> borders = step2(substring);
        LinkedList<Integer> result = new LinkedList<Integer>();
        int compareIndex = 0;
        for (int i = 0; i < string.length(); i++) 
        {
            while (compareIndex > 0 && string.charAt(i) != substring.charAt(compareIndex))
                compareIndex = borders.get(compareIndex - 1);

            if (string.charAt(i) == substring.charAt(compareIndex))
                compareIndex++;

            if (compareIndex == substring.length()) {
                result.addLast(i - compareIndex + 1);
                compareIndex = borders.get(substring.length() - 1);
            }
        }
        return result;
    }
}
