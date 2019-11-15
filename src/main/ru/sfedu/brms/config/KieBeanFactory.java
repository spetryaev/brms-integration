package ru.sfedu.brms.config;

import org.drools.decisiontable.DecisionTableProviderImpl;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.DecisionTableConfiguration;
import org.kie.internal.builder.DecisionTableInputType;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class KieBeanFactory {

    private KieServices kieServices = KieServices.Factory.get();

    /**
     * a method to get a kie container
     * @return
     * @throws IOException
     */
    public KieContainer getKieContainer() throws IOException {
        getKieRepository();
        KieBuilder kb = kieServices.newKieBuilder(getKieFileSystem());
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId());
    }

    /**
     * an easy way to get a ready-to-use session
     * @return
     */
    public KieSession getKieSession(){
        getKieRepository();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();

        kieFileSystem.write(ResourceFactory.newClassPathResource("ru/sfedu/brms/rules/BankDeposit_rules.xls"));

        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();

        KieContainer kContainer = kieServices.newKieContainer(kieModule.getReleaseId());

        return kContainer.newKieSession();

    }

    /**
     * an easy way to get a ready-to-use session with manual resource injection
     * @return
     */
    public KieSession getKieSession(Resource dt) {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem().write(dt);
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();

        KieRepository kieRepository = kieServices.getRepository();
        ReleaseId krDefaultReleaseId = kieRepository.getDefaultReleaseId();

        KieContainer kieContainer = kieServices.newKieContainer(krDefaultReleaseId);
        return kieContainer.newKieSession();
    }


    private KieFileSystem getKieFileSystem() throws IOException{
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        List<String> rules = Arrays.asList("ru/sfedu/brms/rules/BankDeposit_rules.xls");
        for(String rule:rules){
            kieFileSystem.write(ResourceFactory.newClassPathResource(rule));
        }
        return kieFileSystem;

    }

    private void getKieRepository() {
        final KieRepository kieRepository = kieServices.getRepository();
        kieRepository.addKieModule(new KieModule() {
            public ReleaseId getReleaseId() {
                return kieRepository.getDefaultReleaseId();
            }
        });
    }

    /*
     * Can be used for debugging
     * Input excelFile example: com/baeldung/drools/rules/Discount.xls
     */
    public String getDrlFromExcel(String excelFile) {
        DecisionTableConfiguration configuration = KnowledgeBuilderFactory.newDecisionTableConfiguration();
        configuration.setInputType(DecisionTableInputType.XLS);

        Resource dt = ResourceFactory.newClassPathResource(excelFile, getClass());

        DecisionTableProviderImpl decisionTableProvider = new DecisionTableProviderImpl();

        return decisionTableProvider.loadFromResource(dt, null);
    }



}
