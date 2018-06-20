package idwall.desafio.string;

/**
 * Created by Rodrigo Catão Araujo on 06/02/2018.
 */
public abstract class StringFormatter {

    private Integer limit;
    private Boolean justify;

    public StringFormatter() {
        this.limit = 40;
        this.justify = Boolean.TRUE;
    }
    
    public StringFormatter(Integer limit) {
        this.limit = limit;
        this.justify = true;
    }
    
    public StringFormatter(Integer limit, Boolean justify) {
        this.limit = limit;
        this.justify = justify;
    }
    
    /**
     * It receives a text and return it formatted
     *
     * @param text
     * @return formatted text
     */
    public abstract String format(String text);

	public Integer getLimit() {
		return limit;
	}

	public Boolean getJustify() {
		return justify;
	}

}
