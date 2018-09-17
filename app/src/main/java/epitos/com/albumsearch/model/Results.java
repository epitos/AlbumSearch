package epitos.com.albumsearch.model;

public class Results {
    private OpensearchQuery query;

    public OpensearchQuery getOpensearchQuery() { return this.query; }

    public void setOpensearchQuery(OpensearchQuery query) { this.query = query; }

    private String totalResults;

    public String getOpensearchTotalResults() { return this.totalResults; }

    public void setOpensearchTotalResults(String totalResults) { this.totalResults = totalResults; }

    private String startIndex;

    public String getOpensearchStartIndex() { return this.startIndex; }

    public void setOpensearchStartIndex(String startIndex) { this.startIndex = startIndex; }

    private String itemsPerPage;

    public String getOpensearchItemsPerPage() { return this.itemsPerPage; }

    public void setOpensearchItemsPerPage(String itemsPerPage) { this.itemsPerPage = itemsPerPage; }

    private Albummatches albummatches;

    public Albummatches getAlbummatches() { return this.albummatches; }

    public void setAlbummatches(Albummatches albummatches) { this.albummatches = albummatches; }

    private Attr attr;

    public Attr getAttr() { return this.attr; }

    public void setAttr(Attr attr) { this.attr = attr; }
}
