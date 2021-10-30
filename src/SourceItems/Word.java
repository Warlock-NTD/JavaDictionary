package SourceItems;

//lưu dạng UTF-8
public class Word {
	private String word_target;
	private String word_explain;
	private String word_pronounce;

	public void setTarget(String w) {
		this.word_target = w;
	}

	public String getTarget() {
		return this.word_target;
	}

	public void setPronounce(String w) {
		this.word_pronounce = w;
	}

	public String getPronounce() {
		return this.word_pronounce;
	}

	public void setExplain(String m) {
		this.word_explain = m;
	}

	public String getExplain() {
		return this.word_explain;
	}

	public Word(String w, String m, String p) {
		this.word_target = w;
		this.word_explain = m;
		this.word_pronounce = p;
	}

	public Word() {
		this.word_target = "";
		this.word_explain = "";
		this.word_pronounce = "";
	}

	public Word(String w) {
		this.word_target = w;
		this.word_explain = "";
		this.word_pronounce = "";
	}

	public Word(String w, String d) {
		this.word_target = w;
		this.word_explain = d;
		this.word_pronounce = "";
	}
}

