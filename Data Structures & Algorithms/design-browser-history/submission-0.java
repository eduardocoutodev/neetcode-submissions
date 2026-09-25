class BrowserHistory {
    BrowserHistoryNode currentPage;

    public BrowserHistory(String homepage) {
        currentPage = new BrowserHistoryNode(homepage, null, null);
    }
    
    public void visit(String url) {
        currentPage.next = new BrowserHistoryNode(url, currentPage, null);
        currentPage = currentPage.next;
    }
    
    public String back(int steps) {
        while(currentPage.prev != null && steps > 0){
            currentPage = currentPage.prev;
            steps--;
        }
        return currentPage.url;
    }
    
    public String forward(int steps) {
        while(currentPage.next != null && steps > 0){
            currentPage = currentPage.next;
            steps--;
        }

        return currentPage.url;
    }


    private class BrowserHistoryNode{
        String url;
        BrowserHistoryNode prev;
        BrowserHistoryNode next;

        BrowserHistoryNode(String url, BrowserHistoryNode prev, BrowserHistoryNode next){
            this.url = url;
            this.prev = prev;
            this.next = next;
        }   
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */