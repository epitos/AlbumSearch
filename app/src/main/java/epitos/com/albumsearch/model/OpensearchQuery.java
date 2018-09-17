package epitos.com.albumsearch.model;

public class OpensearchQuery {
    private String text;

    public String getText() { return this.text; }

    public void setText(String text) { this.text = text; }

    private String role;

    public String getRole() { return this.role; }

    public void setRole(String role) { this.role = role; }

    private String searchTerms;

    public String getSearchTerms() { return this.searchTerms; }

    public void setSearchTerms(String searchTerms) { this.searchTerms = searchTerms; }

    private String startPage;

    public String getStartPage() { return this.startPage; }

    public void setStartPage(String startPage) { this.startPage = startPage; }
}
