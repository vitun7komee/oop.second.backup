public abstract class Template {

    public boolean isSubstring(String string, String substring) {
        if (string == null || substring == null)
            return false;
        if (string.isEmpty() || substring.isEmpty())
            return false;
        if (substring.length() > string.length())
            return false;
        return step1(string, substring);
    }
    
    protected abstract boolean step1(String string, String substring);
}
