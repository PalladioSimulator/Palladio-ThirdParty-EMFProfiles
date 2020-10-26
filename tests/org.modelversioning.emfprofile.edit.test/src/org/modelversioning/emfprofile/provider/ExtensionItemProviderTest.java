package org.modelversioning.emfprofile.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.emf.ecore.EcoreFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelversioning.emfprofile.EMFProfileFactory;
import org.modelversioning.emfprofile.Extension;

public class ExtensionItemProviderTest {

    private ExtensionItemProvider subject;
    private Extension extension;
    
    @BeforeEach
    public void setup() {
        subject = new ExtensionItemProvider(null);
        extension = createDummyExtension();
    }
    
    private Extension createDummyExtension() {
        var source = EMFProfileFactory.eINSTANCE.createStereotype();
        source.setName("Foo");
        var target = EcoreFactory.eINSTANCE.createEClass();
        target.setName("Bar");
        var extension = EMFProfileFactory.eINSTANCE.createExtension();
        extension.setSource(source);
        extension.setTarget(target);
        return extension;
    }

    @Test
    public void testFullLabel() {        
        assertEquals("Foo -> Bar", subject.getText(extension));
    }
    
    @Test
    public void testMissingTargetLabel() {
        extension.setTarget(null);
        assertEquals("Foo -> ", subject.getText(extension));
    }
    
    @Test
    public void testMissingSourceLabel() {
        extension.setSource(null);
        assertEquals(" -> Bar", subject.getText(extension));
    }
    
    @Test
    public void testMissingSourceAndTargetLabel() {
        extension.setSource(null);
        extension.setTarget(null);
        assertEquals(" -> ", subject.getText(extension));
    }
}
