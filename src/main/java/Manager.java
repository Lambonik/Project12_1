public class Manager {
    private PosterItem[] items = new PosterItem[0];
    private int defaultLimLastAddFilms = 5;
    private int limLastAddFilms;

    public Manager(int limLastAddFilms) {
        this.limLastAddFilms = limLastAddFilms;
    }

    public Manager() {
        limLastAddFilms = defaultLimLastAddFilms;
    }

    public void addItem(PosterItem item) {
        PosterItem[] tpm = new PosterItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tpm[i] = items[i];
        }
        tpm[tpm.length - 1] = item;
        items = tpm;
    }

    public PosterItem[] getItems() {
        return items;
    }

    public void findAll() {
        PosterItem[] tpm = new PosterItem[items.length];
        for (int i = 0; i < items.length; i++) {
            tpm[i] = items[i];
        }
        items = tpm;
    }

    public void findLast() {
        int resultLength = 0;
        if (limLastAddFilms > items.length) {
            resultLength = items.length;
        } else {
            resultLength = limLastAddFilms;
        }
        PosterItem[] last = new PosterItem[resultLength];
        for (int i = 0; i < resultLength; i++) {
            last[i] = items[items.length - 1 - i];
        }
        items = last;
    }
}
