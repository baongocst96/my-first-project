package Quanlyhanghoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class quanlyhanghoa extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenhang;
	private JTextField txtLoaihang;
	private JTextField txtGia;
	private JTextField txtXuatxu;
	


	/* connect batabase*/
	Connection con = null;
	Statement st=null;
	
	private JTable table=new JTable();
	
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlyhanghoa", "root", "");
			System.out.println("ket noi thanh cong !");
		}catch(Exception e) {
			e.printStackTrace();
		}return con;
	}
	
	public ArrayList<Hanghoa> Laythongtinhang(){
		ArrayList<Hanghoa> dshanghoa = new ArrayList<Hanghoa>();
		Connection con = getConnection();
		try {
			st=con.createStatement();
			String sql="SELECT * FROM hanghoa";
			//thuc hien cau truy van 
			ResultSet rs = st.executeQuery(sql);
			Hanghoa hh;
			while(rs.next()) {
				hh=new Hanghoa(rs.getString("Tenhang"),rs.getString("Loaihang"),rs.getInt("Gia"),rs.getString("Xuatxu"));
				//them vao mang
				dshanghoa.add(hh);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}return dshanghoa;
		
	}
	
	public void Hienthidshh() {
		String[] colTieude = new String[] {"Ten hang","Loai Hang","Gia","Xuat xu"};
		ArrayList<Hanghoa> dshanghoa=Laythongtinhang();
		DefaultTableModel model = new DefaultTableModel(colTieude,0);
		Object[]row;
		for(int i=0;i<dshanghoa.size();i++) {
			row=new Object[4];
			
			//gan gia trij
			row[0]=dshanghoa.get(i).getTenhang();
			row[1]=dshanghoa.get(i).getLoaihang();
			row[2]=dshanghoa.get(i).getGia();
			row[3]=dshanghoa.get(i).getXuatxu();
		
			
			model.addRow(row);
			//hienthijtable
			
		}
		table.setToolTipText("empty");
		
		table.setModel(model);
	}
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					
				try {					
					quanlyhanghoa frame = new quanlyhanghoa();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public quanlyhanghoa() {
		getConnection();		
		Hienthidshh();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel banner = new JPanel();
		banner.setBorder(new TitledBorder(null, "Qu\u1EA3n L\u00FD H\u00E0ng H\u00F3a", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_Thongtin = new JPanel();
		panel_Thongtin.setBorder(new TitledBorder(null, "Th\u00F4ng tin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_Danhsach = new JPanel();
		panel_Danhsach.setBorder(new TitledBorder(null, "Danh s\u00E1ch h\u00E0ng h\u00F3a", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_Thongtin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
							.addComponent(panel_Danhsach, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE))
						.addComponent(banner, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(banner, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_Thongtin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_Danhsach, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		//table = new JTable();
		GroupLayout gl_panel_Danhsach = new GroupLayout(panel_Danhsach);
		gl_panel_Danhsach.setHorizontalGroup(
			gl_panel_Danhsach.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Danhsach.createSequentialGroup()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_panel_Danhsach.setVerticalGroup(
			gl_panel_Danhsach.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_Danhsach.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_Danhsach.setLayout(gl_panel_Danhsach);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn H\u00E0ng");
		
		txtTenhang = new JTextField();
		txtTenhang.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Lo\u1EA1i H\u00E0ng");
		
		txtLoaihang = new JTextField();
		txtLoaihang.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Gi\u00E1");
		
		txtGia = new JTextField();
		txtGia.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Xuat xu");
		
		txtXuatxu = new JTextField();
		txtXuatxu.setColumns(10);
		
		JButton btnThem = new JButton("th\u00EAm m\u1EDBi");
		
		JButton btnSua = new JButton("s\u1EEDa");
		
		JButton btnXoa = new JButton("x\u00F3a");
		
		JButton btnDong = new JButton("\u0111\u00F3ng");
		GroupLayout gl_panel_Thongtin = new GroupLayout(panel_Thongtin);
		gl_panel_Thongtin.setHorizontalGroup(
			gl_panel_Thongtin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Thongtin.createSequentialGroup()
					.addGroup(gl_panel_Thongtin.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_Thongtin.createSequentialGroup()
							.addGroup(gl_panel_Thongtin.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addGroup(gl_panel_Thongtin.createSequentialGroup()
									.addGap(6)
									.addGroup(gl_panel_Thongtin.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel_Thongtin.createSequentialGroup()
											.addComponent(lblNewLabel_1)
											.addGap(90))
										.addGroup(gl_panel_Thongtin.createSequentialGroup()
											.addComponent(lblNewLabel)
											.addGap(91))
										.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
							.addGroup(gl_panel_Thongtin.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtTenhang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtLoaihang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtXuatxu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_Thongtin.createSequentialGroup()
							.addComponent(btnThem)
							.addGap(18)
							.addGroup(gl_panel_Thongtin.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDong)
								.addGroup(gl_panel_Thongtin.createSequentialGroup()
									.addComponent(btnSua)
									.addGap(18)
									.addComponent(btnXoa)))))
					.addContainerGap())
		);
		gl_panel_Thongtin.setVerticalGroup(
			gl_panel_Thongtin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Thongtin.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_panel_Thongtin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtTenhang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_Thongtin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtLoaihang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_Thongtin.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_Thongtin.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_2)
							.addGap(18)
							.addComponent(lblNewLabel_3))
						.addGroup(gl_panel_Thongtin.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtXuatxu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addGroup(gl_panel_Thongtin.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnThem)
						.addComponent(btnXoa)
						.addComponent(btnSua))
					.addGap(3)
					.addComponent(btnDong)
					.addContainerGap())
		);
		panel_Thongtin.setLayout(gl_panel_Thongtin);
		
		JLabel lblQunLHng = new JLabel("QU\u1EA2N L\u00DD H\u00C0NG H\u00D3A \u0110\u01A0N GI\u1EA2N");
		lblQunLHng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQunLHng.setForeground(Color.RED);
		lblQunLHng.setBackground(Color.PINK);
		banner.add(lblQunLHng);
		contentPane.setLayout(gl_contentPane);
	}
}
