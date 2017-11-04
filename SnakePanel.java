package AI.Mod;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;






public class SnakePanel extends JPanel implements Runnable{

	Snake snake;
	SnakeAi ai;
	
	/**
	 * Create the panel.
	 */
	public SnakePanel() {
		snake=new Snake();
		Node n=new Node(10,10);//�ߵĳ�ʼλ��
		snake.getS().add(n);
		snake.setFirst(n);
		snake.setLast(n);
		snake.setTail(new Node(0,10));//
		snake.setFood(new Node(80,80));//
		ai=new SnakeAi();
	}
	@Override
	public void paint(Graphics g) {
		 /*
         * 获取此图形上下文的颜色
         * */
		Color c = g.getColor();
        /*
         * 指定图形上下文的颜色
         * */
		g.setColor(Color.GRAY);
        /*
         * 用当前的颜色来填充指定的区域
         * */
		g.fillRect(0, 0, Snake.map_size, Snake.map_size);

		g.setColor(Color.DARK_GRAY);



		g.setColor(Color.YELLOW);//设定颜色，为下面显示文字信息做准备
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.orange);
		g.drawRect(10, 10, Snake.map_size, Snake.map_size);//��ͼ��Χ
		
		g.setColor(Color.white);	
		paintSnake(g,snake);
		
		g.setColor(Color.white);
		paintFood(g,snake.getFood());
		

		int dir=ai.method2(snake,snake.getFood());//
		if(dir==-1){
		System.out.println("GG");
		}
		else{
			snake.move(dir);
		}
	}
	/**
	 *
	 * @param g
	 * @param snake
	 */
	public void paintSnake(Graphics g,Snake snake){
		for(Node n:snake.getS()){
			if(n.toString().equals(snake.getFirst().toString())){
				g.setColor(Color.green);//蛇头为绿色
			}
			if(n.toString().equals(snake.getLast().toString())&&!snake.getFirst().toString().equals(snake.getLast().toString())){
				g.setColor(Color.blue);//蛇尾蓝色
			}
			g.fillRect(n.getX(),n.getY(),Snake.size, Snake.size);
			g.setColor(Color.red);//蛇身白色
		}
	}
	/**
	 * ��ʳ��
	 * @param g
	 * @param food
	 */
	public void paintFood(Graphics g,Node food){
		g.setColor(Color.red);
		g.fillOval(food.getX(), food.getY(), snake.size, snake.size);
	}
	

	public void run() {
		while (true) {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(30);//�ӳ��ٶ�
				this.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
