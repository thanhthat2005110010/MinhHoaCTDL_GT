import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ListHangHoaKhoST {
    private NodeHangHoaKhoST head, tail;
    HangHoaKhoST hangHoa = new HangHoaKhoST();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date ngayNhap = new Date();
    Scanner sc = new Scanner(System.in);
    public ListHangHoaKhoST()
    {
        hangHoa.autoId = 1;
        this.head = null;
        this.tail = null;
    }
    public boolean isEmpty()
    {
        return this.head == null;
    }
    public void ThemHangHoa(HangHoaKhoST hangHoa)
    {
        if(isEmpty())
        {
            this.head = this.tail = new NodeHangHoaKhoST(hangHoa);
            return;
        }
        NodeHangHoaKhoST newNode = new NodeHangHoaKhoST(hangHoa);
        this.tail.setNext(newNode);
        this.tail = newNode;

    }
    public void HienThiHangHoa()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~THONG TIN HANG HOA~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("%-20S %-20S %-20S %-20S %-20S %-20S\n", "ma hang", "ten hang", "so luong", "gia hang", "loai hang", "ngay nhap kho");
        NodeHangHoaKhoST node = this.head;
        while(node != null){
            System.out.printf("%-20d %-20S %-15d %-7.3fVND %20S %20S\n", node.getHangHoa().iD, node.getHangHoa().tenHangHoa, node.getHangHoa().soLuong, node.getHangHoa().giaHang, node.getHangHoa().getLoai(),df.format(node.getHangHoa().ngayNhap)); 
            node = node.getNext();
        }
    }
    public void ThemNhieuHangHoa(HangHoaKhoST...hangHoas)
    {
        for(HangHoaKhoST hangHoa : hangHoas)
        {
            ThemHangHoa(hangHoa);
        }
    }
    public boolean XoaHangHoa(int id)
    {
        NodeHangHoaKhoST node = this.head;
        if(this.head.getHangHoa().getiD() == id){
            this.head = this.head.getNext();
            System.out.println("Da Xoa Doi Tuong Dau Tien!!");
            return true;
        }
        while(node != null)
        {
            if(node.getNext().getHangHoa().getiD() == id){
                node.setNext(node.getNext().getNext());
                System.out.println("Xoa Thanh Cong!!!");
                return true;
            }
            else{
                System.out.println("ID Khong Ton Tai!!");
            }
            node = node.getNext();
        }
        System.out.println("Xoa Khong Thanh Cong!");
        return false;
    }
    public boolean SuaThongTin(int id){
        NodeHangHoaKhoST node = this.head;
        while(node != null)
        {
            if(node.getHangHoa().getiD() == id)
            {
                String loaiHh = null;
                System.out.println("Nhap Ten Hang:");
                String ten = sc.nextLine();
                System.out.println("Nhap So Luong:");
                int soLuong = sc.nextInt();
                System.out.println("Nhap Gia:");
                float gia = sc.nextFloat();
                System.out.println("Nhap Loai Hang [1: Thuc Pham; 2: Sanh Su; 3: Dien May]");
                int l = sc.nextInt();
                switch(l)
                {
                    case 1: loaiHh = "Thuc Pham";
                    break;
                    case 2: loaiHh = "Sanh Su";
                    break;
                    case 3: loaiHh = "Dien May";
                    break;
                    default: System.out.println("Loai Khong Hop Le!!!");
                    break;
                }
                sc.nextLine();
                try {
                    System.out.println("Nhap Ngay Vao Kho [dd/MM/yyyy]");
                    ngayNhap = df.parse(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Ngay Khong Hop Le!!!!");
                }
                node.getHangHoa().setTenHangHoa(ten);
                node.getHangHoa().setSoLuong(soLuong);
                node.getHangHoa().setGiaHang(gia);
                node.getHangHoa().setLoai(loaiHh);
                node.getHangHoa().setNgayNhap(ngayNhap);
                return true;
            }
            node = node.getNext();
        }
        System.out.println("Khong The Sua!!!");
        return false;
    }
    public void SapXepTangDan(){
        NodeHangHoaKhoST node = this.head, node2 = null;
        HangHoaKhoST tempHangHoa;
        if(head == null)
        return;
        else{
            while(node != null){
                node2 = node.next;
                while(node2 != null){
                    if(node.hangHoa.giaHang < node2.hangHoa.giaHang){
                        tempHangHoa = node.hangHoa;
                        node.hangHoa = node2.hangHoa;
                        node2.hangHoa = tempHangHoa;
                    }
                    node2 = node2.next;
                }
                node = node.next;
            }
        }
        HienThiHangHoa();
    }

    public void SapXepGiamDan(){
        NodeHangHoaKhoST node = this.head, node2 = null;
        HangHoaKhoST tempHangHoa;
        if(head == null)
        return;
        else{
            while(node != null){
                node2 = node.next;
                while(node2 != null){
                    if(node.hangHoa.giaHang > node2.hangHoa.giaHang){
                        tempHangHoa = node.hangHoa;
                        node.hangHoa = node2.hangHoa;
                        node2.hangHoa = tempHangHoa;
                    }
                    node2 = node2.next;
                }
                node = node.next;
            }
        }
        HienThiHangHoa();
    }
    public boolean TimKiemTheoLoai(String l){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~THONG TIN HANG HOA~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("%-20S %-20S %-20S %-20S %-20S %-20S\n", "ma hang", "ten hang", "so luong", "gia hang", "loai hang", "ngay nhap kho");
        boolean isFound = false;
        NodeHangHoaKhoST node = this.head;
        while(node != null)
        {
            if(node.getHangHoa().getLoai().contains(l))
            {
                System.out.printf("%-20d %-20S %-15d %-7.3fVND %20S %20S\n", node.getHangHoa().iD, node.getHangHoa().tenHangHoa, node.getHangHoa().soLuong, node.getHangHoa().giaHang, node.getHangHoa().getLoai(),df.format(node.getHangHoa().ngayNhap)); 
                isFound = true;
            }
            node = node.getNext();
        }
        if(!isFound)
        {
            System.out.println("Loai Muon Tim Khong Hop Le!");
            return false;
        }
        return true;
    }
    public boolean TimKiemTheoGia(float gF, float gT){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~THONG TIN HANG HOA~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("%-20S %-20S %-20S %-20S %-20S %-20S\n", "ma hang", "ten hang", "so luong", "gia hang", "loai hang", "ngay nhap kho");
        boolean isFound = false;
        NodeHangHoaKhoST node = this.head;
        while(node != null)
        {
            if(node.getHangHoa().getGiaHang() >= gF && node.getHangHoa().getGiaHang() <= gT)
            {
                System.out.printf("%-20d %-20S %-15d %-7.3fVND %20S %20S\n", node.getHangHoa().iD, node.getHangHoa().tenHangHoa, node.getHangHoa().soLuong, node.getHangHoa().giaHang, node.getHangHoa().getLoai(),df.format(node.getHangHoa().ngayNhap)); 
                isFound = true;
            }
            node = node.getNext();
        }
        if(!isFound)
        {
            System.out.println("Gia Muon Tim Khong Hop Le!");
            return false;
        }
        return true;
    }
    public void ThongKe(){
        NodeHangHoaKhoST node = this.head;
        int sLtemp = 0;
        float gTtemp = 0;
        while(node != null){
            sLtemp += node.getHangHoa().getSoLuong();
            gTtemp += node.getHangHoa().getGiaHang();
            node = node.getNext();
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~BANG THONG KE~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("%-30S %-30S\n", "Tong so luong", "Tong gia tri");
        System.out.printf("%-30d %-12.3fVND\n", sLtemp, gTtemp);
    }
    public void DuLieuMacDinh(){
        try {
            String sDate1 = "20/12/2021";  
            String sDate2 = "12/12/2021";  
            String sDate3 = "10/12/2021";  
            String sDate4 = "19/12/2021";  
            String sDate5 = "21/12/2021";  
            String sDate6 = "01/12/2021";  
            SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");  
            Date date1=formatter1.parse(sDate1);  
            Date date2=formatter1.parse(sDate2);  
            Date date3=formatter1.parse(sDate3);  
            Date date4=formatter1.parse(sDate4);  
            Date date5=formatter1.parse(sDate5);  
            Date date6=formatter1.parse(sDate6); 
            HangHoaKhoST HangHoaKhoST1 = new HangHoaKhoST(100, "Dưa leo", "Thực Phẩm", 200, date3);
            HangHoaKhoST HangHoaKhoST2 = new HangHoaKhoST(1300, "Tai nghe", "Điện Máy", 300, date2);
            HangHoaKhoST HangHoaKhoST3 = new HangHoaKhoST(4000, "Chén sứ", "Sành Sứ", 200, date4);
            HangHoaKhoST HangHoaKhoST4 = new HangHoaKhoST(10000, "Cà chua", "Thực Phẩm", 200, date5);
            HangHoaKhoST HangHoaKhoST5 = new HangHoaKhoST(5000, "Chuột vi tính", "Điện Máy", 300, date1);
            HangHoaKhoST HangHoaKhoST6 = new HangHoaKhoST(500, "Tô sứ", "Sành Sứ", 200, date4);
            HangHoaKhoST HangHoaKhoST7 = new HangHoaKhoST(400, "Dưa hấu", "Thực Phẩm ", 20, date2);
            HangHoaKhoST HangHoaKhoST8 = new HangHoaKhoST(700, "Máy lạnh", "Điện Máy", 600, date5);
            HangHoaKhoST HangHoaKhoST9 = new HangHoaKhoST(3000, "Dĩa sứ", "Sành Sứ", 1200, date4);
            HangHoaKhoST HangHoaKhoST10 = new HangHoaKhoST(2000, "Xoài", "Thực Phẩm", 500, date2);
            HangHoaKhoST HangHoaKhoST11 = new HangHoaKhoST(500, "Máy tính", "Điện Máy", 30, date4);
            HangHoaKhoST HangHoaKhoST12 = new HangHoaKhoST(6000, "Ly sứ", "Sành Sứ", 50, date2);
            HangHoaKhoST HangHoaKhoST13 = new HangHoaKhoST(1000, "Ổi", "Thực Phẩm", 40, date5);
            HangHoaKhoST HangHoaKhoST14 = new HangHoaKhoST(8000, "Laptop", "Điện Máy", 60, date1);
            HangHoaKhoST HangHoaKhoST15 = new HangHoaKhoST(70, "Chai sứ", "Sành Sứ", 750, date3);
            HangHoaKhoST HangHoaKhoST16 = new HangHoaKhoST(9000, "Cóc", "Thực Phẩm", 86, date2);
            HangHoaKhoST HangHoaKhoST17 = new HangHoaKhoST(200, "Máy nước nóng", "Điện Máy", 763, date3);
            HangHoaKhoST HangHoaKhoST18 = new HangHoaKhoST(10, "Bình sứ", "Sành Sứ", 63, date4);
            HangHoaKhoST HangHoaKhoST19 = new HangHoaKhoST(300, "Thịt bò", "Thực Phẩm", 900, date2);
            HangHoaKhoST HangHoaKhoST20 = new HangHoaKhoST(300, "Máy quạt", "Điện Máy", 900, date2);
            ThemHangHoa(HangHoaKhoST1);
            ThemHangHoa(HangHoaKhoST2);
            ThemHangHoa(HangHoaKhoST3);
            ThemHangHoa(HangHoaKhoST4);
            ThemHangHoa(HangHoaKhoST5);
            ThemHangHoa(HangHoaKhoST6);
            ThemHangHoa(HangHoaKhoST7);
            ThemHangHoa(HangHoaKhoST8);
            ThemHangHoa(HangHoaKhoST9);
            ThemHangHoa(HangHoaKhoST10);
            ThemHangHoa(HangHoaKhoST11);
            ThemHangHoa(HangHoaKhoST12);
            ThemHangHoa(HangHoaKhoST13);
            ThemHangHoa(HangHoaKhoST14);
            ThemHangHoa(HangHoaKhoST15);
            ThemHangHoa(HangHoaKhoST16);
            ThemHangHoa(HangHoaKhoST17);
            ThemHangHoa(HangHoaKhoST18);
            ThemHangHoa(HangHoaKhoST19);
            ThemHangHoa(HangHoaKhoST20);
        } catch (Exception e) {
            e.getCause();
        }
    }
}
