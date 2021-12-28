public class NodeHangHoaKhoST {
    public HangHoaKhoST hangHoa;
    public NodeHangHoaKhoST next;

    public NodeHangHoaKhoST(HangHoaKhoST hangHoa)
    {
        this.hangHoa = hangHoa;
        this.next = null;
    }
    public HangHoaKhoST getHangHoa() {
        return hangHoa;
    }
    public void setHangHoa(HangHoaKhoST hangHoa) {
        this.hangHoa = hangHoa;
    }
    public NodeHangHoaKhoST getNext() {
        return next;
    }
    public void setNext(NodeHangHoaKhoST next) {
        this.next = next;
    }
    public NodeHangHoaKhoST(HangHoaKhoST hangHoa, NodeHangHoaKhoST next) {
        this.hangHoa = hangHoa;
        this.next = next;
    }
}
