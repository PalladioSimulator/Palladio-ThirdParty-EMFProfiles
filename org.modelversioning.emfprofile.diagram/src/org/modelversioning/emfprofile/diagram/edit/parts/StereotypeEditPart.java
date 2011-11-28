package org.modelversioning.emfprofile.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.modelversioning.emfprofile.diagram.edit.policies.StereotypeItemSemanticEditPolicy;
import org.modelversioning.emfprofile.diagram.layout.AlphaDropShadowBorder;
import org.modelversioning.emfprofile.diagram.layout.GradientRectangleFigure;
import org.modelversioning.emfprofile.diagram.layout.ToolbarLayoutExt;
import org.modelversioning.emfprofile.diagram.part.EMFProfileVisualIDRegistry;
import org.modelversioning.emfprofile.diagram.providers.EMFProfileElementTypes;

/**
 * @generated
 */
public class StereotypeEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2001;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public StereotypeEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new StereotypeItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new StereotypeFigure();
	}

	/**
	 * @generated
	 */
	public StereotypeFigure getPrimaryShape() {
		return (StereotypeFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof StereotypeNameEditPart) {
			((StereotypeNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureStereotypeNameFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof StereotypeNameEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		return getContentPane();
	}

	/**
	 * @generated not
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		AlphaDropShadowBorder shadowBorder = new AlphaDropShadowBorder();
		shadowBorder.setShouldDrawDropShadow(true);
		result.setBorder(shadowBorder);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(EMFProfileVisualIDRegistry
				.getType(StereotypeNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(EMFProfileElementTypes.Extension_4004);
		types.add(EMFProfileElementTypes.EClassESuperTypes_4002);
		types.add(EMFProfileElementTypes.EReference_4003);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof org.modelversioning.emfprofile.diagram.edit.parts.StereotypeEditPart) {
			types.add(EMFProfileElementTypes.Extension_4004);
		}
		if (targetEditPart instanceof EClassEditPart) {
			types.add(EMFProfileElementTypes.Extension_4004);
		}
		if (targetEditPart instanceof EClass2EditPart) {
			types.add(EMFProfileElementTypes.Extension_4004);
		}
		if (targetEditPart instanceof org.modelversioning.emfprofile.diagram.edit.parts.StereotypeEditPart) {
			types.add(EMFProfileElementTypes.EClassESuperTypes_4002);
		}
		if (targetEditPart instanceof EClassEditPart) {
			types.add(EMFProfileElementTypes.EClassESuperTypes_4002);
		}
		if (targetEditPart instanceof EClass2EditPart) {
			types.add(EMFProfileElementTypes.EClassESuperTypes_4002);
		}
		if (targetEditPart instanceof org.modelversioning.emfprofile.diagram.edit.parts.StereotypeEditPart) {
			types.add(EMFProfileElementTypes.EReference_4003);
		}
		if (targetEditPart instanceof EClassEditPart) {
			types.add(EMFProfileElementTypes.EReference_4003);
		}
		if (targetEditPart instanceof EEnumEditPart) {
			types.add(EMFProfileElementTypes.EReference_4003);
		}
		if (targetEditPart instanceof EDataTypeEditPart) {
			types.add(EMFProfileElementTypes.EReference_4003);
		}
		if (targetEditPart instanceof EClass2EditPart) {
			types.add(EMFProfileElementTypes.EReference_4003);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == EMFProfileElementTypes.Extension_4004) {
			types.add(EMFProfileElementTypes.Stereotype_2001);
			types.add(EMFProfileElementTypes.EClass_2002);
			types.add(EMFProfileElementTypes.EClass_3002);
		} else if (relationshipType == EMFProfileElementTypes.EClassESuperTypes_4002) {
			types.add(EMFProfileElementTypes.Stereotype_2001);
			types.add(EMFProfileElementTypes.EClass_2002);
			types.add(EMFProfileElementTypes.EClass_3002);
		} else if (relationshipType == EMFProfileElementTypes.EReference_4003) {
			types.add(EMFProfileElementTypes.Stereotype_2001);
			types.add(EMFProfileElementTypes.EClass_2002);
			types.add(EMFProfileElementTypes.EEnum_2004);
			types.add(EMFProfileElementTypes.EDataType_2005);
			types.add(EMFProfileElementTypes.EClass_3002);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(EMFProfileElementTypes.Extension_4004);
		types.add(EMFProfileElementTypes.EClassESuperTypes_4002);
		types.add(EMFProfileElementTypes.EReference_4003);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == EMFProfileElementTypes.Extension_4004) {
			types.add(EMFProfileElementTypes.Stereotype_2001);
		} else if (relationshipType == EMFProfileElementTypes.EClassESuperTypes_4002) {
			types.add(EMFProfileElementTypes.Stereotype_2001);
			types.add(EMFProfileElementTypes.EClass_2002);
			types.add(EMFProfileElementTypes.EClass_3002);
		} else if (relationshipType == EMFProfileElementTypes.EReference_4003) {
			types.add(EMFProfileElementTypes.Stereotype_2001);
			types.add(EMFProfileElementTypes.EClass_2002);
			types.add(EMFProfileElementTypes.EClass_3002);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request)
					.getViewAndElementDescriptor()
					.getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter
					.getAdapter(IElementType.class);
			if (type == EMFProfileElementTypes.EAttribute_3001) {
				return getChildBySemanticHint(EMFProfileVisualIDRegistry
						.getType(StereotypeTaggedValueCompEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated NOT
	 */
	public class StereotypeFigure extends GradientRectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureStereotypeNameFigure;

		/**
		 * @generated NOT
		 */
		public StereotypeFigure() {
			ToolbarLayoutExt layoutThis = new ToolbarLayoutExt();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutThis.setSpacing(0);
			layoutThis.setVertical(true);
			layoutThis.setExpandLastItemMajorAxis(true);
			setBackgroundColor(THIS_BACK);
			setForegroundColor(ColorConstants.black);

			this.setLayoutManager(layoutThis);
			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			WrappingLabel stereotypeDecoLabel0 = new WrappingLabel();
			stereotypeDecoLabel0.setText("<<Stereotype>>");
			stereotypeDecoLabel0.setAlignment(PositionConstants.CENTER);

			this.add(stereotypeDecoLabel0);

			fFigureStereotypeNameFigure = new WrappingLabel();
			fFigureStereotypeNameFigure.setText("");
			fFigureStereotypeNameFigure.setAlignment(PositionConstants.TOP);

			this.add(fFigureStereotypeNameFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureStereotypeNameFigure() {
			return fFigureStereotypeNameFigure;
		}

	}

	/**
	 * @generated NOT
	 */
	static final Color THIS_BACK = new Color(null, 202, 225, 255);

}
