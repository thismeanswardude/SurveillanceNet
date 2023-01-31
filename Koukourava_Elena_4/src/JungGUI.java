import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import org.apache.commons.collections15.Transformer;
import edu.uci.ics.jung.visualization.RenderContext;
import edu.uci.ics.jung.visualization.renderers.*;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class JungGUI {
	
	private Registry r;
	private int count=1;
	private String name;
	
	public JungGUI(Registry r){
		
		SparseGraph g = new SparseGraph();
		
		for (Suspect i : r.upoptoi) {	
			g.addVertex(i.getCodeName());
		}
		for (Suspect i : r.upoptoi) {
			for (Suspect j : i.getPithanoiYpoptoi()) {
				g.addEdge(count,i.getCodeName(),j.getCodeName());
				count++;
				}
		}
		
        
        VisualizationImageServer vs = new VisualizationImageServer(new CircleLayout(g), new Dimension(500, 500));
        vs.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        JFrame frame = new JFrame();
        frame.getContentPane().add(vs);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
	}
}
