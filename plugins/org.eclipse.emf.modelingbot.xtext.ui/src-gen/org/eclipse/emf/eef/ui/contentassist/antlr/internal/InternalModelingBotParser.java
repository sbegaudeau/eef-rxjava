package org.eclipse.emf.eef.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.emf.eef.services.ModelingBotGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalModelingBotParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'scenario'", "'{'", "'}'", "'propertiesView'", "'wizard'", "'detailsPage'", "'create project '", "'create model '", "' at '", "' with RootType '", "'check'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=4;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalModelingBotParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalModelingBotParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalModelingBotParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g"; }


     
     	private ModelingBotGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ModelingBotGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleScenario"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:60:1: entryRuleScenario : ruleScenario EOF ;
    public final void entryRuleScenario() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:61:1: ( ruleScenario EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:62:1: ruleScenario EOF
            {
             before(grammarAccess.getScenarioRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario_in_entryRuleScenario61);
            ruleScenario();

            state._fsp--;

             after(grammarAccess.getScenarioRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleScenario"


    // $ANTLR start "ruleScenario"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:69:1: ruleScenario : ( ( rule__Scenario__Group__0 ) ) ;
    public final void ruleScenario() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:73:2: ( ( ( rule__Scenario__Group__0 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:74:1: ( ( rule__Scenario__Group__0 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:74:1: ( ( rule__Scenario__Group__0 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:75:1: ( rule__Scenario__Group__0 )
            {
             before(grammarAccess.getScenarioAccess().getGroup()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:76:1: ( rule__Scenario__Group__0 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:76:2: rule__Scenario__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__0_in_ruleScenario94);
            rule__Scenario__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScenarioAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScenario"


    // $ANTLR start "entryRuleProcessings"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:88:1: entryRuleProcessings : ruleProcessings EOF ;
    public final void entryRuleProcessings() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:89:1: ( ruleProcessings EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:90:1: ruleProcessings EOF
            {
             before(grammarAccess.getProcessingsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleProcessings_in_entryRuleProcessings121);
            ruleProcessings();

            state._fsp--;

             after(grammarAccess.getProcessingsRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProcessings128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProcessings"


    // $ANTLR start "ruleProcessings"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:97:1: ruleProcessings : ( ( rule__Processings__Alternatives ) ) ;
    public final void ruleProcessings() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:101:2: ( ( ( rule__Processings__Alternatives ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:102:1: ( ( rule__Processings__Alternatives ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:102:1: ( ( rule__Processings__Alternatives ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:103:1: ( rule__Processings__Alternatives )
            {
             before(grammarAccess.getProcessingsAccess().getAlternatives()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:104:1: ( rule__Processings__Alternatives )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:104:2: rule__Processings__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Processings__Alternatives_in_ruleProcessings154);
            rule__Processings__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getProcessingsAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProcessings"


    // $ANTLR start "entryRulePropertiesView"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:116:1: entryRulePropertiesView : rulePropertiesView EOF ;
    public final void entryRulePropertiesView() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:117:1: ( rulePropertiesView EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:118:1: rulePropertiesView EOF
            {
             before(grammarAccess.getPropertiesViewRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePropertiesView_in_entryRulePropertiesView181);
            rulePropertiesView();

            state._fsp--;

             after(grammarAccess.getPropertiesViewRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePropertiesView188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePropertiesView"


    // $ANTLR start "rulePropertiesView"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:125:1: rulePropertiesView : ( ( rule__PropertiesView__Group__0 ) ) ;
    public final void rulePropertiesView() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:129:2: ( ( ( rule__PropertiesView__Group__0 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:130:1: ( ( rule__PropertiesView__Group__0 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:130:1: ( ( rule__PropertiesView__Group__0 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:131:1: ( rule__PropertiesView__Group__0 )
            {
             before(grammarAccess.getPropertiesViewAccess().getGroup()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:132:1: ( rule__PropertiesView__Group__0 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:132:2: rule__PropertiesView__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__0_in_rulePropertiesView214);
            rule__PropertiesView__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPropertiesViewAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePropertiesView"


    // $ANTLR start "entryRuleWizard"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:144:1: entryRuleWizard : ruleWizard EOF ;
    public final void entryRuleWizard() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:145:1: ( ruleWizard EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:146:1: ruleWizard EOF
            {
             before(grammarAccess.getWizardRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleWizard_in_entryRuleWizard241);
            ruleWizard();

            state._fsp--;

             after(grammarAccess.getWizardRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWizard248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWizard"


    // $ANTLR start "ruleWizard"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:153:1: ruleWizard : ( ( rule__Wizard__Group__0 ) ) ;
    public final void ruleWizard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:157:2: ( ( ( rule__Wizard__Group__0 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:158:1: ( ( rule__Wizard__Group__0 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:158:1: ( ( rule__Wizard__Group__0 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:159:1: ( rule__Wizard__Group__0 )
            {
             before(grammarAccess.getWizardAccess().getGroup()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:160:1: ( rule__Wizard__Group__0 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:160:2: rule__Wizard__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__0_in_ruleWizard274);
            rule__Wizard__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWizardAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWizard"


    // $ANTLR start "entryRuleDetails"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:172:1: entryRuleDetails : ruleDetails EOF ;
    public final void entryRuleDetails() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:173:1: ( ruleDetails EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:174:1: ruleDetails EOF
            {
             before(grammarAccess.getDetailsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDetails_in_entryRuleDetails301);
            ruleDetails();

            state._fsp--;

             after(grammarAccess.getDetailsRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDetails308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDetails"


    // $ANTLR start "ruleDetails"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:181:1: ruleDetails : ( ( rule__Details__Group__0 ) ) ;
    public final void ruleDetails() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:185:2: ( ( ( rule__Details__Group__0 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:186:1: ( ( rule__Details__Group__0 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:186:1: ( ( rule__Details__Group__0 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:187:1: ( rule__Details__Group__0 )
            {
             before(grammarAccess.getDetailsAccess().getGroup()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:188:1: ( rule__Details__Group__0 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:188:2: rule__Details__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__0_in_ruleDetails334);
            rule__Details__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDetailsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDetails"


    // $ANTLR start "entryRuleSubProcessings"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:200:1: entryRuleSubProcessings : ruleSubProcessings EOF ;
    public final void entryRuleSubProcessings() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:201:1: ( ruleSubProcessings EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:202:1: ruleSubProcessings EOF
            {
             before(grammarAccess.getSubProcessingsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubProcessings_in_entryRuleSubProcessings361);
            ruleSubProcessings();

            state._fsp--;

             after(grammarAccess.getSubProcessingsRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubProcessings368); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSubProcessings"


    // $ANTLR start "ruleSubProcessings"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:209:1: ruleSubProcessings : ( ( rule__SubProcessings__Alternatives ) ) ;
    public final void ruleSubProcessings() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:213:2: ( ( ( rule__SubProcessings__Alternatives ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:214:1: ( ( rule__SubProcessings__Alternatives ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:214:1: ( ( rule__SubProcessings__Alternatives ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:215:1: ( rule__SubProcessings__Alternatives )
            {
             before(grammarAccess.getSubProcessingsAccess().getAlternatives()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:216:1: ( rule__SubProcessings__Alternatives )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:216:2: rule__SubProcessings__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__SubProcessings__Alternatives_in_ruleSubProcessings394);
            rule__SubProcessings__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSubProcessingsAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSubProcessings"


    // $ANTLR start "entryRuleAction"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:228:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:229:1: ( ruleAction EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:230:1: ruleAction EOF
            {
             before(grammarAccess.getActionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAction_in_entryRuleAction421);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getActionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAction428); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:237:1: ruleAction : ( ( rule__Action__Alternatives ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:241:2: ( ( ( rule__Action__Alternatives ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:242:1: ( ( rule__Action__Alternatives ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:242:1: ( ( rule__Action__Alternatives ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:243:1: ( rule__Action__Alternatives )
            {
             before(grammarAccess.getActionAccess().getAlternatives()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:244:1: ( rule__Action__Alternatives )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:244:2: rule__Action__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Alternatives_in_ruleAction454);
            rule__Action__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleEclipseAction"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:256:1: entryRuleEclipseAction : ruleEclipseAction EOF ;
    public final void entryRuleEclipseAction() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:257:1: ( ruleEclipseAction EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:258:1: ruleEclipseAction EOF
            {
             before(grammarAccess.getEclipseActionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEclipseAction_in_entryRuleEclipseAction481);
            ruleEclipseAction();

            state._fsp--;

             after(grammarAccess.getEclipseActionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEclipseAction488); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEclipseAction"


    // $ANTLR start "ruleEclipseAction"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:265:1: ruleEclipseAction : ( ( rule__EclipseAction__Alternatives ) ) ;
    public final void ruleEclipseAction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:269:2: ( ( ( rule__EclipseAction__Alternatives ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:270:1: ( ( rule__EclipseAction__Alternatives ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:270:1: ( ( rule__EclipseAction__Alternatives ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:271:1: ( rule__EclipseAction__Alternatives )
            {
             before(grammarAccess.getEclipseActionAccess().getAlternatives()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:272:1: ( rule__EclipseAction__Alternatives )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:272:2: rule__EclipseAction__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EclipseAction__Alternatives_in_ruleEclipseAction514);
            rule__EclipseAction__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEclipseActionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEclipseAction"


    // $ANTLR start "entryRuleCreateProject"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:284:1: entryRuleCreateProject : ruleCreateProject EOF ;
    public final void entryRuleCreateProject() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:285:1: ( ruleCreateProject EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:286:1: ruleCreateProject EOF
            {
             before(grammarAccess.getCreateProjectRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCreateProject_in_entryRuleCreateProject541);
            ruleCreateProject();

            state._fsp--;

             after(grammarAccess.getCreateProjectRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCreateProject548); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCreateProject"


    // $ANTLR start "ruleCreateProject"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:293:1: ruleCreateProject : ( ( rule__CreateProject__Group__0 ) ) ;
    public final void ruleCreateProject() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:297:2: ( ( ( rule__CreateProject__Group__0 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:298:1: ( ( rule__CreateProject__Group__0 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:298:1: ( ( rule__CreateProject__Group__0 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:299:1: ( rule__CreateProject__Group__0 )
            {
             before(grammarAccess.getCreateProjectAccess().getGroup()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:300:1: ( rule__CreateProject__Group__0 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:300:2: rule__CreateProject__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateProject__Group__0_in_ruleCreateProject574);
            rule__CreateProject__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCreateProjectAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCreateProject"


    // $ANTLR start "entryRuleCreateModel"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:312:1: entryRuleCreateModel : ruleCreateModel EOF ;
    public final void entryRuleCreateModel() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:313:1: ( ruleCreateModel EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:314:1: ruleCreateModel EOF
            {
             before(grammarAccess.getCreateModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCreateModel_in_entryRuleCreateModel601);
            ruleCreateModel();

            state._fsp--;

             after(grammarAccess.getCreateModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCreateModel608); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCreateModel"


    // $ANTLR start "ruleCreateModel"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:321:1: ruleCreateModel : ( ( rule__CreateModel__Group__0 ) ) ;
    public final void ruleCreateModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:325:2: ( ( ( rule__CreateModel__Group__0 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:326:1: ( ( rule__CreateModel__Group__0 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:326:1: ( ( rule__CreateModel__Group__0 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:327:1: ( rule__CreateModel__Group__0 )
            {
             before(grammarAccess.getCreateModelAccess().getGroup()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:328:1: ( rule__CreateModel__Group__0 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:328:2: rule__CreateModel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__0_in_ruleCreateModel634);
            rule__CreateModel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCreateModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCreateModel"


    // $ANTLR start "entryRuleEEFAction"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:340:1: entryRuleEEFAction : ruleEEFAction EOF ;
    public final void entryRuleEEFAction() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:341:1: ( ruleEEFAction EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:342:1: ruleEEFAction EOF
            {
             before(grammarAccess.getEEFActionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEEFAction_in_entryRuleEEFAction661);
            ruleEEFAction();

            state._fsp--;

             after(grammarAccess.getEEFActionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEEFAction668); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEEFAction"


    // $ANTLR start "ruleEEFAction"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:349:1: ruleEEFAction : ( ruleCheck ) ;
    public final void ruleEEFAction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:353:2: ( ( ruleCheck ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:354:1: ( ruleCheck )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:354:1: ( ruleCheck )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:355:1: ruleCheck
            {
             before(grammarAccess.getEEFActionAccess().getCheckParserRuleCall()); 
            pushFollow(FollowSets000.FOLLOW_ruleCheck_in_ruleEEFAction694);
            ruleCheck();

            state._fsp--;

             after(grammarAccess.getEEFActionAccess().getCheckParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEEFAction"


    // $ANTLR start "entryRuleCheck"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:368:1: entryRuleCheck : ruleCheck EOF ;
    public final void entryRuleCheck() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:369:1: ( ruleCheck EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:370:1: ruleCheck EOF
            {
             before(grammarAccess.getCheckRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCheck_in_entryRuleCheck720);
            ruleCheck();

            state._fsp--;

             after(grammarAccess.getCheckRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCheck727); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCheck"


    // $ANTLR start "ruleCheck"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:377:1: ruleCheck : ( ( rule__Check__Group__0 ) ) ;
    public final void ruleCheck() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:381:2: ( ( ( rule__Check__Group__0 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:382:1: ( ( rule__Check__Group__0 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:382:1: ( ( rule__Check__Group__0 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:383:1: ( rule__Check__Group__0 )
            {
             before(grammarAccess.getCheckAccess().getGroup()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:384:1: ( rule__Check__Group__0 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:384:2: rule__Check__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Check__Group__0_in_ruleCheck753);
            rule__Check__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCheckAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCheck"


    // $ANTLR start "entryRuleEString"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:396:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:397:1: ( ruleEString EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:398:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString780);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString787); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:405:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:409:2: ( ( ( rule__EString__Alternatives ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:410:1: ( ( rule__EString__Alternatives ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:410:1: ( ( rule__EString__Alternatives ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:411:1: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:412:1: ( rule__EString__Alternatives )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:412:2: rule__EString__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EString__Alternatives_in_ruleEString813);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "rule__Processings__Alternatives"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:424:1: rule__Processings__Alternatives : ( ( ruleDetails ) | ( ruleWizard ) | ( rulePropertiesView ) | ( ruleAction ) );
    public final void rule__Processings__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:428:1: ( ( ruleDetails ) | ( ruleWizard ) | ( rulePropertiesView ) | ( ruleAction ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt1=1;
                }
                break;
            case 15:
                {
                alt1=2;
                }
                break;
            case 14:
                {
                alt1=3;
                }
                break;
            case 17:
            case 18:
            case 21:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:429:1: ( ruleDetails )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:429:1: ( ruleDetails )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:430:1: ruleDetails
                    {
                     before(grammarAccess.getProcessingsAccess().getDetailsParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleDetails_in_rule__Processings__Alternatives849);
                    ruleDetails();

                    state._fsp--;

                     after(grammarAccess.getProcessingsAccess().getDetailsParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:435:6: ( ruleWizard )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:435:6: ( ruleWizard )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:436:1: ruleWizard
                    {
                     before(grammarAccess.getProcessingsAccess().getWizardParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleWizard_in_rule__Processings__Alternatives866);
                    ruleWizard();

                    state._fsp--;

                     after(grammarAccess.getProcessingsAccess().getWizardParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:441:6: ( rulePropertiesView )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:441:6: ( rulePropertiesView )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:442:1: rulePropertiesView
                    {
                     before(grammarAccess.getProcessingsAccess().getPropertiesViewParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_rulePropertiesView_in_rule__Processings__Alternatives883);
                    rulePropertiesView();

                    state._fsp--;

                     after(grammarAccess.getProcessingsAccess().getPropertiesViewParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:447:6: ( ruleAction )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:447:6: ( ruleAction )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:448:1: ruleAction
                    {
                     before(grammarAccess.getProcessingsAccess().getActionParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAction_in_rule__Processings__Alternatives900);
                    ruleAction();

                    state._fsp--;

                     after(grammarAccess.getProcessingsAccess().getActionParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processings__Alternatives"


    // $ANTLR start "rule__SubProcessings__Alternatives"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:458:1: rule__SubProcessings__Alternatives : ( ( ruleWizard ) | ( ruleDetails ) | ( rulePropertiesView ) | ( ruleAction ) );
    public final void rule__SubProcessings__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:462:1: ( ( ruleWizard ) | ( ruleDetails ) | ( rulePropertiesView ) | ( ruleAction ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt2=1;
                }
                break;
            case 16:
                {
                alt2=2;
                }
                break;
            case 14:
                {
                alt2=3;
                }
                break;
            case 17:
            case 18:
            case 21:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:463:1: ( ruleWizard )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:463:1: ( ruleWizard )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:464:1: ruleWizard
                    {
                     before(grammarAccess.getSubProcessingsAccess().getWizardParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleWizard_in_rule__SubProcessings__Alternatives932);
                    ruleWizard();

                    state._fsp--;

                     after(grammarAccess.getSubProcessingsAccess().getWizardParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:469:6: ( ruleDetails )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:469:6: ( ruleDetails )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:470:1: ruleDetails
                    {
                     before(grammarAccess.getSubProcessingsAccess().getDetailsParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleDetails_in_rule__SubProcessings__Alternatives949);
                    ruleDetails();

                    state._fsp--;

                     after(grammarAccess.getSubProcessingsAccess().getDetailsParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:475:6: ( rulePropertiesView )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:475:6: ( rulePropertiesView )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:476:1: rulePropertiesView
                    {
                     before(grammarAccess.getSubProcessingsAccess().getPropertiesViewParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_rulePropertiesView_in_rule__SubProcessings__Alternatives966);
                    rulePropertiesView();

                    state._fsp--;

                     after(grammarAccess.getSubProcessingsAccess().getPropertiesViewParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:481:6: ( ruleAction )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:481:6: ( ruleAction )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:482:1: ruleAction
                    {
                     before(grammarAccess.getSubProcessingsAccess().getActionParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAction_in_rule__SubProcessings__Alternatives983);
                    ruleAction();

                    state._fsp--;

                     after(grammarAccess.getSubProcessingsAccess().getActionParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubProcessings__Alternatives"


    // $ANTLR start "rule__Action__Alternatives"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:492:1: rule__Action__Alternatives : ( ( ruleEclipseAction ) | ( ruleEEFAction ) );
    public final void rule__Action__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:496:1: ( ( ruleEclipseAction ) | ( ruleEEFAction ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=17 && LA3_0<=18)) ) {
                alt3=1;
            }
            else if ( (LA3_0==21) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:497:1: ( ruleEclipseAction )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:497:1: ( ruleEclipseAction )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:498:1: ruleEclipseAction
                    {
                     before(grammarAccess.getActionAccess().getEclipseActionParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleEclipseAction_in_rule__Action__Alternatives1015);
                    ruleEclipseAction();

                    state._fsp--;

                     after(grammarAccess.getActionAccess().getEclipseActionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:503:6: ( ruleEEFAction )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:503:6: ( ruleEEFAction )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:504:1: ruleEEFAction
                    {
                     before(grammarAccess.getActionAccess().getEEFActionParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleEEFAction_in_rule__Action__Alternatives1032);
                    ruleEEFAction();

                    state._fsp--;

                     after(grammarAccess.getActionAccess().getEEFActionParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Alternatives"


    // $ANTLR start "rule__EclipseAction__Alternatives"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:514:1: rule__EclipseAction__Alternatives : ( ( ruleCreateProject ) | ( ruleCreateModel ) );
    public final void rule__EclipseAction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:518:1: ( ( ruleCreateProject ) | ( ruleCreateModel ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            else if ( (LA4_0==18) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:519:1: ( ruleCreateProject )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:519:1: ( ruleCreateProject )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:520:1: ruleCreateProject
                    {
                     before(grammarAccess.getEclipseActionAccess().getCreateProjectParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleCreateProject_in_rule__EclipseAction__Alternatives1064);
                    ruleCreateProject();

                    state._fsp--;

                     after(grammarAccess.getEclipseActionAccess().getCreateProjectParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:525:6: ( ruleCreateModel )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:525:6: ( ruleCreateModel )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:526:1: ruleCreateModel
                    {
                     before(grammarAccess.getEclipseActionAccess().getCreateModelParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleCreateModel_in_rule__EclipseAction__Alternatives1081);
                    ruleCreateModel();

                    state._fsp--;

                     after(grammarAccess.getEclipseActionAccess().getCreateModelParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EclipseAction__Alternatives"


    // $ANTLR start "rule__EString__Alternatives"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:536:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:540:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:541:1: ( RULE_STRING )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:541:1: ( RULE_STRING )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:542:1: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EString__Alternatives1113); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:547:6: ( RULE_ID )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:547:6: ( RULE_ID )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:548:1: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EString__Alternatives1130); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__Scenario__Group__0"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:560:1: rule__Scenario__Group__0 : rule__Scenario__Group__0__Impl rule__Scenario__Group__1 ;
    public final void rule__Scenario__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:564:1: ( rule__Scenario__Group__0__Impl rule__Scenario__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:565:2: rule__Scenario__Group__0__Impl rule__Scenario__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__0__Impl_in_rule__Scenario__Group__01160);
            rule__Scenario__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__1_in_rule__Scenario__Group__01163);
            rule__Scenario__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__0"


    // $ANTLR start "rule__Scenario__Group__0__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:572:1: rule__Scenario__Group__0__Impl : ( 'scenario' ) ;
    public final void rule__Scenario__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:576:1: ( ( 'scenario' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:577:1: ( 'scenario' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:577:1: ( 'scenario' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:578:1: 'scenario'
            {
             before(grammarAccess.getScenarioAccess().getScenarioKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Scenario__Group__0__Impl1191); 
             after(grammarAccess.getScenarioAccess().getScenarioKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__0__Impl"


    // $ANTLR start "rule__Scenario__Group__1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:591:1: rule__Scenario__Group__1 : rule__Scenario__Group__1__Impl rule__Scenario__Group__2 ;
    public final void rule__Scenario__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:595:1: ( rule__Scenario__Group__1__Impl rule__Scenario__Group__2 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:596:2: rule__Scenario__Group__1__Impl rule__Scenario__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__1__Impl_in_rule__Scenario__Group__11222);
            rule__Scenario__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__2_in_rule__Scenario__Group__11225);
            rule__Scenario__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__1"


    // $ANTLR start "rule__Scenario__Group__1__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:603:1: rule__Scenario__Group__1__Impl : ( ( rule__Scenario__NameAssignment_1 ) ) ;
    public final void rule__Scenario__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:607:1: ( ( ( rule__Scenario__NameAssignment_1 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:608:1: ( ( rule__Scenario__NameAssignment_1 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:608:1: ( ( rule__Scenario__NameAssignment_1 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:609:1: ( rule__Scenario__NameAssignment_1 )
            {
             before(grammarAccess.getScenarioAccess().getNameAssignment_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:610:1: ( rule__Scenario__NameAssignment_1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:610:2: rule__Scenario__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario__NameAssignment_1_in_rule__Scenario__Group__1__Impl1252);
            rule__Scenario__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getScenarioAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__1__Impl"


    // $ANTLR start "rule__Scenario__Group__2"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:620:1: rule__Scenario__Group__2 : rule__Scenario__Group__2__Impl rule__Scenario__Group__3 ;
    public final void rule__Scenario__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:624:1: ( rule__Scenario__Group__2__Impl rule__Scenario__Group__3 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:625:2: rule__Scenario__Group__2__Impl rule__Scenario__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__2__Impl_in_rule__Scenario__Group__21282);
            rule__Scenario__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__3_in_rule__Scenario__Group__21285);
            rule__Scenario__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__2"


    // $ANTLR start "rule__Scenario__Group__2__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:632:1: rule__Scenario__Group__2__Impl : ( '{' ) ;
    public final void rule__Scenario__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:636:1: ( ( '{' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:637:1: ( '{' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:637:1: ( '{' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:638:1: '{'
            {
             before(grammarAccess.getScenarioAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Scenario__Group__2__Impl1313); 
             after(grammarAccess.getScenarioAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__2__Impl"


    // $ANTLR start "rule__Scenario__Group__3"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:651:1: rule__Scenario__Group__3 : rule__Scenario__Group__3__Impl rule__Scenario__Group__4 ;
    public final void rule__Scenario__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:655:1: ( rule__Scenario__Group__3__Impl rule__Scenario__Group__4 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:656:2: rule__Scenario__Group__3__Impl rule__Scenario__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__3__Impl_in_rule__Scenario__Group__31344);
            rule__Scenario__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__4_in_rule__Scenario__Group__31347);
            rule__Scenario__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__3"


    // $ANTLR start "rule__Scenario__Group__3__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:663:1: rule__Scenario__Group__3__Impl : ( ( rule__Scenario__ProcessingsAssignment_3 )* ) ;
    public final void rule__Scenario__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:667:1: ( ( ( rule__Scenario__ProcessingsAssignment_3 )* ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:668:1: ( ( rule__Scenario__ProcessingsAssignment_3 )* )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:668:1: ( ( rule__Scenario__ProcessingsAssignment_3 )* )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:669:1: ( rule__Scenario__ProcessingsAssignment_3 )*
            {
             before(grammarAccess.getScenarioAccess().getProcessingsAssignment_3()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:670:1: ( rule__Scenario__ProcessingsAssignment_3 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=14 && LA6_0<=18)||LA6_0==21) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:670:2: rule__Scenario__ProcessingsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Scenario__ProcessingsAssignment_3_in_rule__Scenario__Group__3__Impl1374);
            	    rule__Scenario__ProcessingsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getScenarioAccess().getProcessingsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__3__Impl"


    // $ANTLR start "rule__Scenario__Group__4"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:680:1: rule__Scenario__Group__4 : rule__Scenario__Group__4__Impl ;
    public final void rule__Scenario__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:684:1: ( rule__Scenario__Group__4__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:685:2: rule__Scenario__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__4__Impl_in_rule__Scenario__Group__41405);
            rule__Scenario__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__4"


    // $ANTLR start "rule__Scenario__Group__4__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:691:1: rule__Scenario__Group__4__Impl : ( '}' ) ;
    public final void rule__Scenario__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:695:1: ( ( '}' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:696:1: ( '}' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:696:1: ( '}' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:697:1: '}'
            {
             before(grammarAccess.getScenarioAccess().getRightCurlyBracketKeyword_4()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Scenario__Group__4__Impl1433); 
             after(grammarAccess.getScenarioAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__4__Impl"


    // $ANTLR start "rule__PropertiesView__Group__0"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:720:1: rule__PropertiesView__Group__0 : rule__PropertiesView__Group__0__Impl rule__PropertiesView__Group__1 ;
    public final void rule__PropertiesView__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:724:1: ( rule__PropertiesView__Group__0__Impl rule__PropertiesView__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:725:2: rule__PropertiesView__Group__0__Impl rule__PropertiesView__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__0__Impl_in_rule__PropertiesView__Group__01474);
            rule__PropertiesView__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__1_in_rule__PropertiesView__Group__01477);
            rule__PropertiesView__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertiesView__Group__0"


    // $ANTLR start "rule__PropertiesView__Group__0__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:732:1: rule__PropertiesView__Group__0__Impl : ( 'propertiesView' ) ;
    public final void rule__PropertiesView__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:736:1: ( ( 'propertiesView' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:737:1: ( 'propertiesView' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:737:1: ( 'propertiesView' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:738:1: 'propertiesView'
            {
             before(grammarAccess.getPropertiesViewAccess().getPropertiesViewKeyword_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__PropertiesView__Group__0__Impl1505); 
             after(grammarAccess.getPropertiesViewAccess().getPropertiesViewKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertiesView__Group__0__Impl"


    // $ANTLR start "rule__PropertiesView__Group__1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:751:1: rule__PropertiesView__Group__1 : rule__PropertiesView__Group__1__Impl rule__PropertiesView__Group__2 ;
    public final void rule__PropertiesView__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:755:1: ( rule__PropertiesView__Group__1__Impl rule__PropertiesView__Group__2 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:756:2: rule__PropertiesView__Group__1__Impl rule__PropertiesView__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__1__Impl_in_rule__PropertiesView__Group__11536);
            rule__PropertiesView__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__2_in_rule__PropertiesView__Group__11539);
            rule__PropertiesView__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertiesView__Group__1"


    // $ANTLR start "rule__PropertiesView__Group__1__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:763:1: rule__PropertiesView__Group__1__Impl : ( ( rule__PropertiesView__NameAssignment_1 )? ) ;
    public final void rule__PropertiesView__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:767:1: ( ( ( rule__PropertiesView__NameAssignment_1 )? ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:768:1: ( ( rule__PropertiesView__NameAssignment_1 )? )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:768:1: ( ( rule__PropertiesView__NameAssignment_1 )? )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:769:1: ( rule__PropertiesView__NameAssignment_1 )?
            {
             before(grammarAccess.getPropertiesViewAccess().getNameAssignment_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:770:1: ( rule__PropertiesView__NameAssignment_1 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_ID)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:770:2: rule__PropertiesView__NameAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__NameAssignment_1_in_rule__PropertiesView__Group__1__Impl1566);
                    rule__PropertiesView__NameAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPropertiesViewAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertiesView__Group__1__Impl"


    // $ANTLR start "rule__PropertiesView__Group__2"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:780:1: rule__PropertiesView__Group__2 : rule__PropertiesView__Group__2__Impl rule__PropertiesView__Group__3 ;
    public final void rule__PropertiesView__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:784:1: ( rule__PropertiesView__Group__2__Impl rule__PropertiesView__Group__3 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:785:2: rule__PropertiesView__Group__2__Impl rule__PropertiesView__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__2__Impl_in_rule__PropertiesView__Group__21597);
            rule__PropertiesView__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__3_in_rule__PropertiesView__Group__21600);
            rule__PropertiesView__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertiesView__Group__2"


    // $ANTLR start "rule__PropertiesView__Group__2__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:792:1: rule__PropertiesView__Group__2__Impl : ( '{' ) ;
    public final void rule__PropertiesView__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:796:1: ( ( '{' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:797:1: ( '{' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:797:1: ( '{' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:798:1: '{'
            {
             before(grammarAccess.getPropertiesViewAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__PropertiesView__Group__2__Impl1628); 
             after(grammarAccess.getPropertiesViewAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertiesView__Group__2__Impl"


    // $ANTLR start "rule__PropertiesView__Group__3"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:811:1: rule__PropertiesView__Group__3 : rule__PropertiesView__Group__3__Impl rule__PropertiesView__Group__4 ;
    public final void rule__PropertiesView__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:815:1: ( rule__PropertiesView__Group__3__Impl rule__PropertiesView__Group__4 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:816:2: rule__PropertiesView__Group__3__Impl rule__PropertiesView__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__3__Impl_in_rule__PropertiesView__Group__31659);
            rule__PropertiesView__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__4_in_rule__PropertiesView__Group__31662);
            rule__PropertiesView__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertiesView__Group__3"


    // $ANTLR start "rule__PropertiesView__Group__3__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:823:1: rule__PropertiesView__Group__3__Impl : ( ( rule__PropertiesView__ProcessingsAssignment_3 )* ) ;
    public final void rule__PropertiesView__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:827:1: ( ( ( rule__PropertiesView__ProcessingsAssignment_3 )* ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:828:1: ( ( rule__PropertiesView__ProcessingsAssignment_3 )* )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:828:1: ( ( rule__PropertiesView__ProcessingsAssignment_3 )* )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:829:1: ( rule__PropertiesView__ProcessingsAssignment_3 )*
            {
             before(grammarAccess.getPropertiesViewAccess().getProcessingsAssignment_3()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:830:1: ( rule__PropertiesView__ProcessingsAssignment_3 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=14 && LA8_0<=18)||LA8_0==21) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:830:2: rule__PropertiesView__ProcessingsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__ProcessingsAssignment_3_in_rule__PropertiesView__Group__3__Impl1689);
            	    rule__PropertiesView__ProcessingsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getPropertiesViewAccess().getProcessingsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertiesView__Group__3__Impl"


    // $ANTLR start "rule__PropertiesView__Group__4"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:840:1: rule__PropertiesView__Group__4 : rule__PropertiesView__Group__4__Impl ;
    public final void rule__PropertiesView__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:844:1: ( rule__PropertiesView__Group__4__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:845:2: rule__PropertiesView__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__4__Impl_in_rule__PropertiesView__Group__41720);
            rule__PropertiesView__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertiesView__Group__4"


    // $ANTLR start "rule__PropertiesView__Group__4__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:851:1: rule__PropertiesView__Group__4__Impl : ( '}' ) ;
    public final void rule__PropertiesView__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:855:1: ( ( '}' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:856:1: ( '}' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:856:1: ( '}' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:857:1: '}'
            {
             before(grammarAccess.getPropertiesViewAccess().getRightCurlyBracketKeyword_4()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__PropertiesView__Group__4__Impl1748); 
             after(grammarAccess.getPropertiesViewAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertiesView__Group__4__Impl"


    // $ANTLR start "rule__Wizard__Group__0"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:880:1: rule__Wizard__Group__0 : rule__Wizard__Group__0__Impl rule__Wizard__Group__1 ;
    public final void rule__Wizard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:884:1: ( rule__Wizard__Group__0__Impl rule__Wizard__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:885:2: rule__Wizard__Group__0__Impl rule__Wizard__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__0__Impl_in_rule__Wizard__Group__01789);
            rule__Wizard__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__1_in_rule__Wizard__Group__01792);
            rule__Wizard__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wizard__Group__0"


    // $ANTLR start "rule__Wizard__Group__0__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:892:1: rule__Wizard__Group__0__Impl : ( 'wizard' ) ;
    public final void rule__Wizard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:896:1: ( ( 'wizard' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:897:1: ( 'wizard' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:897:1: ( 'wizard' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:898:1: 'wizard'
            {
             before(grammarAccess.getWizardAccess().getWizardKeyword_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Wizard__Group__0__Impl1820); 
             after(grammarAccess.getWizardAccess().getWizardKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wizard__Group__0__Impl"


    // $ANTLR start "rule__Wizard__Group__1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:911:1: rule__Wizard__Group__1 : rule__Wizard__Group__1__Impl rule__Wizard__Group__2 ;
    public final void rule__Wizard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:915:1: ( rule__Wizard__Group__1__Impl rule__Wizard__Group__2 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:916:2: rule__Wizard__Group__1__Impl rule__Wizard__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__1__Impl_in_rule__Wizard__Group__11851);
            rule__Wizard__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__2_in_rule__Wizard__Group__11854);
            rule__Wizard__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wizard__Group__1"


    // $ANTLR start "rule__Wizard__Group__1__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:923:1: rule__Wizard__Group__1__Impl : ( ( rule__Wizard__NameAssignment_1 )? ) ;
    public final void rule__Wizard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:927:1: ( ( ( rule__Wizard__NameAssignment_1 )? ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:928:1: ( ( rule__Wizard__NameAssignment_1 )? )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:928:1: ( ( rule__Wizard__NameAssignment_1 )? )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:929:1: ( rule__Wizard__NameAssignment_1 )?
            {
             before(grammarAccess.getWizardAccess().getNameAssignment_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:930:1: ( rule__Wizard__NameAssignment_1 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=RULE_STRING && LA9_0<=RULE_ID)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:930:2: rule__Wizard__NameAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Wizard__NameAssignment_1_in_rule__Wizard__Group__1__Impl1881);
                    rule__Wizard__NameAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getWizardAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wizard__Group__1__Impl"


    // $ANTLR start "rule__Wizard__Group__2"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:940:1: rule__Wizard__Group__2 : rule__Wizard__Group__2__Impl rule__Wizard__Group__3 ;
    public final void rule__Wizard__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:944:1: ( rule__Wizard__Group__2__Impl rule__Wizard__Group__3 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:945:2: rule__Wizard__Group__2__Impl rule__Wizard__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__2__Impl_in_rule__Wizard__Group__21912);
            rule__Wizard__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__3_in_rule__Wizard__Group__21915);
            rule__Wizard__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wizard__Group__2"


    // $ANTLR start "rule__Wizard__Group__2__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:952:1: rule__Wizard__Group__2__Impl : ( '{' ) ;
    public final void rule__Wizard__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:956:1: ( ( '{' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:957:1: ( '{' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:957:1: ( '{' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:958:1: '{'
            {
             before(grammarAccess.getWizardAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Wizard__Group__2__Impl1943); 
             after(grammarAccess.getWizardAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wizard__Group__2__Impl"


    // $ANTLR start "rule__Wizard__Group__3"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:971:1: rule__Wizard__Group__3 : rule__Wizard__Group__3__Impl rule__Wizard__Group__4 ;
    public final void rule__Wizard__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:975:1: ( rule__Wizard__Group__3__Impl rule__Wizard__Group__4 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:976:2: rule__Wizard__Group__3__Impl rule__Wizard__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__3__Impl_in_rule__Wizard__Group__31974);
            rule__Wizard__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__4_in_rule__Wizard__Group__31977);
            rule__Wizard__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wizard__Group__3"


    // $ANTLR start "rule__Wizard__Group__3__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:983:1: rule__Wizard__Group__3__Impl : ( ( rule__Wizard__ProcessingsAssignment_3 )* ) ;
    public final void rule__Wizard__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:987:1: ( ( ( rule__Wizard__ProcessingsAssignment_3 )* ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:988:1: ( ( rule__Wizard__ProcessingsAssignment_3 )* )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:988:1: ( ( rule__Wizard__ProcessingsAssignment_3 )* )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:989:1: ( rule__Wizard__ProcessingsAssignment_3 )*
            {
             before(grammarAccess.getWizardAccess().getProcessingsAssignment_3()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:990:1: ( rule__Wizard__ProcessingsAssignment_3 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=14 && LA10_0<=18)||LA10_0==21) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:990:2: rule__Wizard__ProcessingsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Wizard__ProcessingsAssignment_3_in_rule__Wizard__Group__3__Impl2004);
            	    rule__Wizard__ProcessingsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getWizardAccess().getProcessingsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wizard__Group__3__Impl"


    // $ANTLR start "rule__Wizard__Group__4"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1000:1: rule__Wizard__Group__4 : rule__Wizard__Group__4__Impl ;
    public final void rule__Wizard__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1004:1: ( rule__Wizard__Group__4__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1005:2: rule__Wizard__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__4__Impl_in_rule__Wizard__Group__42035);
            rule__Wizard__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wizard__Group__4"


    // $ANTLR start "rule__Wizard__Group__4__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1011:1: rule__Wizard__Group__4__Impl : ( '}' ) ;
    public final void rule__Wizard__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1015:1: ( ( '}' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1016:1: ( '}' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1016:1: ( '}' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1017:1: '}'
            {
             before(grammarAccess.getWizardAccess().getRightCurlyBracketKeyword_4()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Wizard__Group__4__Impl2063); 
             after(grammarAccess.getWizardAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wizard__Group__4__Impl"


    // $ANTLR start "rule__Details__Group__0"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1040:1: rule__Details__Group__0 : rule__Details__Group__0__Impl rule__Details__Group__1 ;
    public final void rule__Details__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1044:1: ( rule__Details__Group__0__Impl rule__Details__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1045:2: rule__Details__Group__0__Impl rule__Details__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__0__Impl_in_rule__Details__Group__02104);
            rule__Details__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__1_in_rule__Details__Group__02107);
            rule__Details__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Details__Group__0"


    // $ANTLR start "rule__Details__Group__0__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1052:1: rule__Details__Group__0__Impl : ( 'detailsPage' ) ;
    public final void rule__Details__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1056:1: ( ( 'detailsPage' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1057:1: ( 'detailsPage' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1057:1: ( 'detailsPage' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1058:1: 'detailsPage'
            {
             before(grammarAccess.getDetailsAccess().getDetailsPageKeyword_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Details__Group__0__Impl2135); 
             after(grammarAccess.getDetailsAccess().getDetailsPageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Details__Group__0__Impl"


    // $ANTLR start "rule__Details__Group__1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1071:1: rule__Details__Group__1 : rule__Details__Group__1__Impl rule__Details__Group__2 ;
    public final void rule__Details__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1075:1: ( rule__Details__Group__1__Impl rule__Details__Group__2 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1076:2: rule__Details__Group__1__Impl rule__Details__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__1__Impl_in_rule__Details__Group__12166);
            rule__Details__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__2_in_rule__Details__Group__12169);
            rule__Details__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Details__Group__1"


    // $ANTLR start "rule__Details__Group__1__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1083:1: rule__Details__Group__1__Impl : ( ( rule__Details__NameAssignment_1 )? ) ;
    public final void rule__Details__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1087:1: ( ( ( rule__Details__NameAssignment_1 )? ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1088:1: ( ( rule__Details__NameAssignment_1 )? )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1088:1: ( ( rule__Details__NameAssignment_1 )? )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1089:1: ( rule__Details__NameAssignment_1 )?
            {
             before(grammarAccess.getDetailsAccess().getNameAssignment_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1090:1: ( rule__Details__NameAssignment_1 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=RULE_STRING && LA11_0<=RULE_ID)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1090:2: rule__Details__NameAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Details__NameAssignment_1_in_rule__Details__Group__1__Impl2196);
                    rule__Details__NameAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDetailsAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Details__Group__1__Impl"


    // $ANTLR start "rule__Details__Group__2"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1100:1: rule__Details__Group__2 : rule__Details__Group__2__Impl rule__Details__Group__3 ;
    public final void rule__Details__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1104:1: ( rule__Details__Group__2__Impl rule__Details__Group__3 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1105:2: rule__Details__Group__2__Impl rule__Details__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__2__Impl_in_rule__Details__Group__22227);
            rule__Details__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__3_in_rule__Details__Group__22230);
            rule__Details__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Details__Group__2"


    // $ANTLR start "rule__Details__Group__2__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1112:1: rule__Details__Group__2__Impl : ( '{' ) ;
    public final void rule__Details__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1116:1: ( ( '{' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1117:1: ( '{' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1117:1: ( '{' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1118:1: '{'
            {
             before(grammarAccess.getDetailsAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Details__Group__2__Impl2258); 
             after(grammarAccess.getDetailsAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Details__Group__2__Impl"


    // $ANTLR start "rule__Details__Group__3"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1131:1: rule__Details__Group__3 : rule__Details__Group__3__Impl rule__Details__Group__4 ;
    public final void rule__Details__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1135:1: ( rule__Details__Group__3__Impl rule__Details__Group__4 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1136:2: rule__Details__Group__3__Impl rule__Details__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__3__Impl_in_rule__Details__Group__32289);
            rule__Details__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__4_in_rule__Details__Group__32292);
            rule__Details__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Details__Group__3"


    // $ANTLR start "rule__Details__Group__3__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1143:1: rule__Details__Group__3__Impl : ( ( rule__Details__ProcessingsAssignment_3 )* ) ;
    public final void rule__Details__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1147:1: ( ( ( rule__Details__ProcessingsAssignment_3 )* ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1148:1: ( ( rule__Details__ProcessingsAssignment_3 )* )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1148:1: ( ( rule__Details__ProcessingsAssignment_3 )* )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1149:1: ( rule__Details__ProcessingsAssignment_3 )*
            {
             before(grammarAccess.getDetailsAccess().getProcessingsAssignment_3()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1150:1: ( rule__Details__ProcessingsAssignment_3 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=14 && LA12_0<=18)||LA12_0==21) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1150:2: rule__Details__ProcessingsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Details__ProcessingsAssignment_3_in_rule__Details__Group__3__Impl2319);
            	    rule__Details__ProcessingsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getDetailsAccess().getProcessingsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Details__Group__3__Impl"


    // $ANTLR start "rule__Details__Group__4"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1160:1: rule__Details__Group__4 : rule__Details__Group__4__Impl ;
    public final void rule__Details__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1164:1: ( rule__Details__Group__4__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1165:2: rule__Details__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__4__Impl_in_rule__Details__Group__42350);
            rule__Details__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Details__Group__4"


    // $ANTLR start "rule__Details__Group__4__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1171:1: rule__Details__Group__4__Impl : ( '}' ) ;
    public final void rule__Details__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1175:1: ( ( '}' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1176:1: ( '}' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1176:1: ( '}' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1177:1: '}'
            {
             before(grammarAccess.getDetailsAccess().getRightCurlyBracketKeyword_4()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Details__Group__4__Impl2378); 
             after(grammarAccess.getDetailsAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Details__Group__4__Impl"


    // $ANTLR start "rule__CreateProject__Group__0"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1200:1: rule__CreateProject__Group__0 : rule__CreateProject__Group__0__Impl rule__CreateProject__Group__1 ;
    public final void rule__CreateProject__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1204:1: ( rule__CreateProject__Group__0__Impl rule__CreateProject__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1205:2: rule__CreateProject__Group__0__Impl rule__CreateProject__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateProject__Group__0__Impl_in_rule__CreateProject__Group__02419);
            rule__CreateProject__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CreateProject__Group__1_in_rule__CreateProject__Group__02422);
            rule__CreateProject__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateProject__Group__0"


    // $ANTLR start "rule__CreateProject__Group__0__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1212:1: rule__CreateProject__Group__0__Impl : ( 'create project ' ) ;
    public final void rule__CreateProject__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1216:1: ( ( 'create project ' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1217:1: ( 'create project ' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1217:1: ( 'create project ' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1218:1: 'create project '
            {
             before(grammarAccess.getCreateProjectAccess().getCreateProjectKeyword_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__CreateProject__Group__0__Impl2450); 
             after(grammarAccess.getCreateProjectAccess().getCreateProjectKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateProject__Group__0__Impl"


    // $ANTLR start "rule__CreateProject__Group__1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1231:1: rule__CreateProject__Group__1 : rule__CreateProject__Group__1__Impl ;
    public final void rule__CreateProject__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1235:1: ( rule__CreateProject__Group__1__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1236:2: rule__CreateProject__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateProject__Group__1__Impl_in_rule__CreateProject__Group__12481);
            rule__CreateProject__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateProject__Group__1"


    // $ANTLR start "rule__CreateProject__Group__1__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1242:1: rule__CreateProject__Group__1__Impl : ( ( rule__CreateProject__ProjectNameAssignment_1 ) ) ;
    public final void rule__CreateProject__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1246:1: ( ( ( rule__CreateProject__ProjectNameAssignment_1 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1247:1: ( ( rule__CreateProject__ProjectNameAssignment_1 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1247:1: ( ( rule__CreateProject__ProjectNameAssignment_1 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1248:1: ( rule__CreateProject__ProjectNameAssignment_1 )
            {
             before(grammarAccess.getCreateProjectAccess().getProjectNameAssignment_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1249:1: ( rule__CreateProject__ProjectNameAssignment_1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1249:2: rule__CreateProject__ProjectNameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateProject__ProjectNameAssignment_1_in_rule__CreateProject__Group__1__Impl2508);
            rule__CreateProject__ProjectNameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCreateProjectAccess().getProjectNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateProject__Group__1__Impl"


    // $ANTLR start "rule__CreateModel__Group__0"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1263:1: rule__CreateModel__Group__0 : rule__CreateModel__Group__0__Impl rule__CreateModel__Group__1 ;
    public final void rule__CreateModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1267:1: ( rule__CreateModel__Group__0__Impl rule__CreateModel__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1268:2: rule__CreateModel__Group__0__Impl rule__CreateModel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__0__Impl_in_rule__CreateModel__Group__02542);
            rule__CreateModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__1_in_rule__CreateModel__Group__02545);
            rule__CreateModel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateModel__Group__0"


    // $ANTLR start "rule__CreateModel__Group__0__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1275:1: rule__CreateModel__Group__0__Impl : ( 'create model ' ) ;
    public final void rule__CreateModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1279:1: ( ( 'create model ' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1280:1: ( 'create model ' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1280:1: ( 'create model ' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1281:1: 'create model '
            {
             before(grammarAccess.getCreateModelAccess().getCreateModelKeyword_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__CreateModel__Group__0__Impl2573); 
             after(grammarAccess.getCreateModelAccess().getCreateModelKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateModel__Group__0__Impl"


    // $ANTLR start "rule__CreateModel__Group__1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1294:1: rule__CreateModel__Group__1 : rule__CreateModel__Group__1__Impl rule__CreateModel__Group__2 ;
    public final void rule__CreateModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1298:1: ( rule__CreateModel__Group__1__Impl rule__CreateModel__Group__2 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1299:2: rule__CreateModel__Group__1__Impl rule__CreateModel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__1__Impl_in_rule__CreateModel__Group__12604);
            rule__CreateModel__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__2_in_rule__CreateModel__Group__12607);
            rule__CreateModel__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateModel__Group__1"


    // $ANTLR start "rule__CreateModel__Group__1__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1306:1: rule__CreateModel__Group__1__Impl : ( ( rule__CreateModel__ModelNameAssignment_1 ) ) ;
    public final void rule__CreateModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1310:1: ( ( ( rule__CreateModel__ModelNameAssignment_1 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1311:1: ( ( rule__CreateModel__ModelNameAssignment_1 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1311:1: ( ( rule__CreateModel__ModelNameAssignment_1 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1312:1: ( rule__CreateModel__ModelNameAssignment_1 )
            {
             before(grammarAccess.getCreateModelAccess().getModelNameAssignment_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1313:1: ( rule__CreateModel__ModelNameAssignment_1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1313:2: rule__CreateModel__ModelNameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__ModelNameAssignment_1_in_rule__CreateModel__Group__1__Impl2634);
            rule__CreateModel__ModelNameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCreateModelAccess().getModelNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateModel__Group__1__Impl"


    // $ANTLR start "rule__CreateModel__Group__2"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1323:1: rule__CreateModel__Group__2 : rule__CreateModel__Group__2__Impl rule__CreateModel__Group__3 ;
    public final void rule__CreateModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1327:1: ( rule__CreateModel__Group__2__Impl rule__CreateModel__Group__3 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1328:2: rule__CreateModel__Group__2__Impl rule__CreateModel__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__2__Impl_in_rule__CreateModel__Group__22664);
            rule__CreateModel__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__3_in_rule__CreateModel__Group__22667);
            rule__CreateModel__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateModel__Group__2"


    // $ANTLR start "rule__CreateModel__Group__2__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1335:1: rule__CreateModel__Group__2__Impl : ( ' at ' ) ;
    public final void rule__CreateModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1339:1: ( ( ' at ' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1340:1: ( ' at ' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1340:1: ( ' at ' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1341:1: ' at '
            {
             before(grammarAccess.getCreateModelAccess().getAtKeyword_2()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__CreateModel__Group__2__Impl2695); 
             after(grammarAccess.getCreateModelAccess().getAtKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateModel__Group__2__Impl"


    // $ANTLR start "rule__CreateModel__Group__3"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1354:1: rule__CreateModel__Group__3 : rule__CreateModel__Group__3__Impl rule__CreateModel__Group__4 ;
    public final void rule__CreateModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1358:1: ( rule__CreateModel__Group__3__Impl rule__CreateModel__Group__4 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1359:2: rule__CreateModel__Group__3__Impl rule__CreateModel__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__3__Impl_in_rule__CreateModel__Group__32726);
            rule__CreateModel__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__4_in_rule__CreateModel__Group__32729);
            rule__CreateModel__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateModel__Group__3"


    // $ANTLR start "rule__CreateModel__Group__3__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1366:1: rule__CreateModel__Group__3__Impl : ( ( rule__CreateModel__PathAssignment_3 ) ) ;
    public final void rule__CreateModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1370:1: ( ( ( rule__CreateModel__PathAssignment_3 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1371:1: ( ( rule__CreateModel__PathAssignment_3 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1371:1: ( ( rule__CreateModel__PathAssignment_3 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1372:1: ( rule__CreateModel__PathAssignment_3 )
            {
             before(grammarAccess.getCreateModelAccess().getPathAssignment_3()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1373:1: ( rule__CreateModel__PathAssignment_3 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1373:2: rule__CreateModel__PathAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__PathAssignment_3_in_rule__CreateModel__Group__3__Impl2756);
            rule__CreateModel__PathAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCreateModelAccess().getPathAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateModel__Group__3__Impl"


    // $ANTLR start "rule__CreateModel__Group__4"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1383:1: rule__CreateModel__Group__4 : rule__CreateModel__Group__4__Impl rule__CreateModel__Group__5 ;
    public final void rule__CreateModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1387:1: ( rule__CreateModel__Group__4__Impl rule__CreateModel__Group__5 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1388:2: rule__CreateModel__Group__4__Impl rule__CreateModel__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__4__Impl_in_rule__CreateModel__Group__42786);
            rule__CreateModel__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__5_in_rule__CreateModel__Group__42789);
            rule__CreateModel__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateModel__Group__4"


    // $ANTLR start "rule__CreateModel__Group__4__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1395:1: rule__CreateModel__Group__4__Impl : ( ' with RootType ' ) ;
    public final void rule__CreateModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1399:1: ( ( ' with RootType ' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1400:1: ( ' with RootType ' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1400:1: ( ' with RootType ' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1401:1: ' with RootType '
            {
             before(grammarAccess.getCreateModelAccess().getWithRootTypeKeyword_4()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__CreateModel__Group__4__Impl2817); 
             after(grammarAccess.getCreateModelAccess().getWithRootTypeKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateModel__Group__4__Impl"


    // $ANTLR start "rule__CreateModel__Group__5"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1414:1: rule__CreateModel__Group__5 : rule__CreateModel__Group__5__Impl ;
    public final void rule__CreateModel__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1418:1: ( rule__CreateModel__Group__5__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1419:2: rule__CreateModel__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__5__Impl_in_rule__CreateModel__Group__52848);
            rule__CreateModel__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateModel__Group__5"


    // $ANTLR start "rule__CreateModel__Group__5__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1425:1: rule__CreateModel__Group__5__Impl : ( ( rule__CreateModel__RootURIAssignment_5 ) ) ;
    public final void rule__CreateModel__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1429:1: ( ( ( rule__CreateModel__RootURIAssignment_5 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1430:1: ( ( rule__CreateModel__RootURIAssignment_5 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1430:1: ( ( rule__CreateModel__RootURIAssignment_5 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1431:1: ( rule__CreateModel__RootURIAssignment_5 )
            {
             before(grammarAccess.getCreateModelAccess().getRootURIAssignment_5()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1432:1: ( rule__CreateModel__RootURIAssignment_5 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1432:2: rule__CreateModel__RootURIAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__RootURIAssignment_5_in_rule__CreateModel__Group__5__Impl2875);
            rule__CreateModel__RootURIAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getCreateModelAccess().getRootURIAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateModel__Group__5__Impl"


    // $ANTLR start "rule__Check__Group__0"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1454:1: rule__Check__Group__0 : rule__Check__Group__0__Impl rule__Check__Group__1 ;
    public final void rule__Check__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1458:1: ( rule__Check__Group__0__Impl rule__Check__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1459:2: rule__Check__Group__0__Impl rule__Check__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Check__Group__0__Impl_in_rule__Check__Group__02917);
            rule__Check__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Check__Group__1_in_rule__Check__Group__02920);
            rule__Check__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Check__Group__0"


    // $ANTLR start "rule__Check__Group__0__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1466:1: rule__Check__Group__0__Impl : ( 'check' ) ;
    public final void rule__Check__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1470:1: ( ( 'check' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1471:1: ( 'check' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1471:1: ( 'check' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1472:1: 'check'
            {
             before(grammarAccess.getCheckAccess().getCheckKeyword_0()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Check__Group__0__Impl2948); 
             after(grammarAccess.getCheckAccess().getCheckKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Check__Group__0__Impl"


    // $ANTLR start "rule__Check__Group__1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1485:1: rule__Check__Group__1 : rule__Check__Group__1__Impl ;
    public final void rule__Check__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1489:1: ( rule__Check__Group__1__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1490:2: rule__Check__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Check__Group__1__Impl_in_rule__Check__Group__12979);
            rule__Check__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Check__Group__1"


    // $ANTLR start "rule__Check__Group__1__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1496:1: rule__Check__Group__1__Impl : ( () ) ;
    public final void rule__Check__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1500:1: ( ( () ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1501:1: ( () )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1501:1: ( () )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1502:1: ()
            {
             before(grammarAccess.getCheckAccess().getCheckAction_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1503:1: ()
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1505:1: 
            {
            }

             after(grammarAccess.getCheckAccess().getCheckAction_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Check__Group__1__Impl"


    // $ANTLR start "rule__Scenario__NameAssignment_1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1520:1: rule__Scenario__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Scenario__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1524:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1525:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1525:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1526:1: ruleEString
            {
             before(grammarAccess.getScenarioAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Scenario__NameAssignment_13046);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getScenarioAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__NameAssignment_1"


    // $ANTLR start "rule__Scenario__ProcessingsAssignment_3"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1535:1: rule__Scenario__ProcessingsAssignment_3 : ( ruleProcessings ) ;
    public final void rule__Scenario__ProcessingsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1539:1: ( ( ruleProcessings ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1540:1: ( ruleProcessings )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1540:1: ( ruleProcessings )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1541:1: ruleProcessings
            {
             before(grammarAccess.getScenarioAccess().getProcessingsProcessingsParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleProcessings_in_rule__Scenario__ProcessingsAssignment_33077);
            ruleProcessings();

            state._fsp--;

             after(grammarAccess.getScenarioAccess().getProcessingsProcessingsParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__ProcessingsAssignment_3"


    // $ANTLR start "rule__PropertiesView__NameAssignment_1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1550:1: rule__PropertiesView__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__PropertiesView__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1554:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1555:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1555:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1556:1: ruleEString
            {
             before(grammarAccess.getPropertiesViewAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__PropertiesView__NameAssignment_13108);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getPropertiesViewAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertiesView__NameAssignment_1"


    // $ANTLR start "rule__PropertiesView__ProcessingsAssignment_3"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1565:1: rule__PropertiesView__ProcessingsAssignment_3 : ( ruleSubProcessings ) ;
    public final void rule__PropertiesView__ProcessingsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1569:1: ( ( ruleSubProcessings ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1570:1: ( ruleSubProcessings )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1570:1: ( ruleSubProcessings )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1571:1: ruleSubProcessings
            {
             before(grammarAccess.getPropertiesViewAccess().getProcessingsSubProcessingsParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubProcessings_in_rule__PropertiesView__ProcessingsAssignment_33139);
            ruleSubProcessings();

            state._fsp--;

             after(grammarAccess.getPropertiesViewAccess().getProcessingsSubProcessingsParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertiesView__ProcessingsAssignment_3"


    // $ANTLR start "rule__Wizard__NameAssignment_1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1580:1: rule__Wizard__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Wizard__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1584:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1585:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1585:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1586:1: ruleEString
            {
             before(grammarAccess.getWizardAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Wizard__NameAssignment_13170);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getWizardAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wizard__NameAssignment_1"


    // $ANTLR start "rule__Wizard__ProcessingsAssignment_3"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1595:1: rule__Wizard__ProcessingsAssignment_3 : ( ruleSubProcessings ) ;
    public final void rule__Wizard__ProcessingsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1599:1: ( ( ruleSubProcessings ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1600:1: ( ruleSubProcessings )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1600:1: ( ruleSubProcessings )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1601:1: ruleSubProcessings
            {
             before(grammarAccess.getWizardAccess().getProcessingsSubProcessingsParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubProcessings_in_rule__Wizard__ProcessingsAssignment_33201);
            ruleSubProcessings();

            state._fsp--;

             after(grammarAccess.getWizardAccess().getProcessingsSubProcessingsParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wizard__ProcessingsAssignment_3"


    // $ANTLR start "rule__Details__NameAssignment_1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1610:1: rule__Details__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Details__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1614:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1615:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1615:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1616:1: ruleEString
            {
             before(grammarAccess.getDetailsAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Details__NameAssignment_13232);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getDetailsAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Details__NameAssignment_1"


    // $ANTLR start "rule__Details__ProcessingsAssignment_3"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1625:1: rule__Details__ProcessingsAssignment_3 : ( ruleSubProcessings ) ;
    public final void rule__Details__ProcessingsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1629:1: ( ( ruleSubProcessings ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1630:1: ( ruleSubProcessings )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1630:1: ( ruleSubProcessings )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1631:1: ruleSubProcessings
            {
             before(grammarAccess.getDetailsAccess().getProcessingsSubProcessingsParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubProcessings_in_rule__Details__ProcessingsAssignment_33263);
            ruleSubProcessings();

            state._fsp--;

             after(grammarAccess.getDetailsAccess().getProcessingsSubProcessingsParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Details__ProcessingsAssignment_3"


    // $ANTLR start "rule__CreateProject__ProjectNameAssignment_1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1640:1: rule__CreateProject__ProjectNameAssignment_1 : ( ruleEString ) ;
    public final void rule__CreateProject__ProjectNameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1644:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1645:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1645:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1646:1: ruleEString
            {
             before(grammarAccess.getCreateProjectAccess().getProjectNameEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__CreateProject__ProjectNameAssignment_13294);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getCreateProjectAccess().getProjectNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateProject__ProjectNameAssignment_1"


    // $ANTLR start "rule__CreateModel__ModelNameAssignment_1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1655:1: rule__CreateModel__ModelNameAssignment_1 : ( ruleEString ) ;
    public final void rule__CreateModel__ModelNameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1659:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1660:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1660:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1661:1: ruleEString
            {
             before(grammarAccess.getCreateModelAccess().getModelNameEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__CreateModel__ModelNameAssignment_13325);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getCreateModelAccess().getModelNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateModel__ModelNameAssignment_1"


    // $ANTLR start "rule__CreateModel__PathAssignment_3"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1670:1: rule__CreateModel__PathAssignment_3 : ( ruleEString ) ;
    public final void rule__CreateModel__PathAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1674:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1675:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1675:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1676:1: ruleEString
            {
             before(grammarAccess.getCreateModelAccess().getPathEStringParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__CreateModel__PathAssignment_33356);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getCreateModelAccess().getPathEStringParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateModel__PathAssignment_3"


    // $ANTLR start "rule__CreateModel__RootURIAssignment_5"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1685:1: rule__CreateModel__RootURIAssignment_5 : ( ruleEString ) ;
    public final void rule__CreateModel__RootURIAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1689:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1690:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1690:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1691:1: ruleEString
            {
             before(grammarAccess.getCreateModelAccess().getRootURIEStringParserRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__CreateModel__RootURIAssignment_53387);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getCreateModelAccess().getRootURIEStringParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateModel__RootURIAssignment_5"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleScenario_in_entryRuleScenario61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario__Group__0_in_ruleScenario94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProcessings_in_entryRuleProcessings121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProcessings128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Processings__Alternatives_in_ruleProcessings154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertiesView_in_entryRulePropertiesView181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePropertiesView188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__0_in_rulePropertiesView214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWizard_in_entryRuleWizard241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWizard248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wizard__Group__0_in_ruleWizard274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDetails_in_entryRuleDetails301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDetails308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Details__Group__0_in_ruleDetails334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubProcessings_in_entryRuleSubProcessings361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubProcessings368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubProcessings__Alternatives_in_ruleSubProcessings394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_entryRuleAction421 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAction428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Alternatives_in_ruleAction454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEclipseAction_in_entryRuleEclipseAction481 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEclipseAction488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EclipseAction__Alternatives_in_ruleEclipseAction514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateProject_in_entryRuleCreateProject541 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCreateProject548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateProject__Group__0_in_ruleCreateProject574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateModel_in_entryRuleCreateModel601 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCreateModel608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__0_in_ruleCreateModel634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEFAction_in_entryRuleEEFAction661 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEEFAction668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCheck_in_ruleEEFAction694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCheck_in_entryRuleCheck720 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCheck727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Check__Group__0_in_ruleCheck753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString780 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EString__Alternatives_in_ruleEString813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDetails_in_rule__Processings__Alternatives849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWizard_in_rule__Processings__Alternatives866 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertiesView_in_rule__Processings__Alternatives883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_rule__Processings__Alternatives900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWizard_in_rule__SubProcessings__Alternatives932 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDetails_in_rule__SubProcessings__Alternatives949 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertiesView_in_rule__SubProcessings__Alternatives966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_rule__SubProcessings__Alternatives983 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEclipseAction_in_rule__Action__Alternatives1015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEFAction_in_rule__Action__Alternatives1032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateProject_in_rule__EclipseAction__Alternatives1064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateModel_in_rule__EclipseAction__Alternatives1081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EString__Alternatives1113 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EString__Alternatives1130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario__Group__0__Impl_in_rule__Scenario__Group__01160 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Scenario__Group__1_in_rule__Scenario__Group__01163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Scenario__Group__0__Impl1191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario__Group__1__Impl_in_rule__Scenario__Group__11222 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Scenario__Group__2_in_rule__Scenario__Group__11225 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario__NameAssignment_1_in_rule__Scenario__Group__1__Impl1252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario__Group__2__Impl_in_rule__Scenario__Group__21282 = new BitSet(new long[]{0x000000000027E000L});
        public static final BitSet FOLLOW_rule__Scenario__Group__3_in_rule__Scenario__Group__21285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Scenario__Group__2__Impl1313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario__Group__3__Impl_in_rule__Scenario__Group__31344 = new BitSet(new long[]{0x000000000027E000L});
        public static final BitSet FOLLOW_rule__Scenario__Group__4_in_rule__Scenario__Group__31347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario__ProcessingsAssignment_3_in_rule__Scenario__Group__3__Impl1374 = new BitSet(new long[]{0x000000000027C002L});
        public static final BitSet FOLLOW_rule__Scenario__Group__4__Impl_in_rule__Scenario__Group__41405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Scenario__Group__4__Impl1433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__0__Impl_in_rule__PropertiesView__Group__01474 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__1_in_rule__PropertiesView__Group__01477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__PropertiesView__Group__0__Impl1505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__1__Impl_in_rule__PropertiesView__Group__11536 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__2_in_rule__PropertiesView__Group__11539 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertiesView__NameAssignment_1_in_rule__PropertiesView__Group__1__Impl1566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__2__Impl_in_rule__PropertiesView__Group__21597 = new BitSet(new long[]{0x000000000027E000L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__3_in_rule__PropertiesView__Group__21600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__PropertiesView__Group__2__Impl1628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__3__Impl_in_rule__PropertiesView__Group__31659 = new BitSet(new long[]{0x000000000027E000L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__4_in_rule__PropertiesView__Group__31662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertiesView__ProcessingsAssignment_3_in_rule__PropertiesView__Group__3__Impl1689 = new BitSet(new long[]{0x000000000027C002L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__4__Impl_in_rule__PropertiesView__Group__41720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__PropertiesView__Group__4__Impl1748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wizard__Group__0__Impl_in_rule__Wizard__Group__01789 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_rule__Wizard__Group__1_in_rule__Wizard__Group__01792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Wizard__Group__0__Impl1820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wizard__Group__1__Impl_in_rule__Wizard__Group__11851 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_rule__Wizard__Group__2_in_rule__Wizard__Group__11854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wizard__NameAssignment_1_in_rule__Wizard__Group__1__Impl1881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wizard__Group__2__Impl_in_rule__Wizard__Group__21912 = new BitSet(new long[]{0x000000000027E000L});
        public static final BitSet FOLLOW_rule__Wizard__Group__3_in_rule__Wizard__Group__21915 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Wizard__Group__2__Impl1943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wizard__Group__3__Impl_in_rule__Wizard__Group__31974 = new BitSet(new long[]{0x000000000027E000L});
        public static final BitSet FOLLOW_rule__Wizard__Group__4_in_rule__Wizard__Group__31977 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wizard__ProcessingsAssignment_3_in_rule__Wizard__Group__3__Impl2004 = new BitSet(new long[]{0x000000000027C002L});
        public static final BitSet FOLLOW_rule__Wizard__Group__4__Impl_in_rule__Wizard__Group__42035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Wizard__Group__4__Impl2063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Details__Group__0__Impl_in_rule__Details__Group__02104 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_rule__Details__Group__1_in_rule__Details__Group__02107 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Details__Group__0__Impl2135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Details__Group__1__Impl_in_rule__Details__Group__12166 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_rule__Details__Group__2_in_rule__Details__Group__12169 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Details__NameAssignment_1_in_rule__Details__Group__1__Impl2196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Details__Group__2__Impl_in_rule__Details__Group__22227 = new BitSet(new long[]{0x000000000027E000L});
        public static final BitSet FOLLOW_rule__Details__Group__3_in_rule__Details__Group__22230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Details__Group__2__Impl2258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Details__Group__3__Impl_in_rule__Details__Group__32289 = new BitSet(new long[]{0x000000000027E000L});
        public static final BitSet FOLLOW_rule__Details__Group__4_in_rule__Details__Group__32292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Details__ProcessingsAssignment_3_in_rule__Details__Group__3__Impl2319 = new BitSet(new long[]{0x000000000027C002L});
        public static final BitSet FOLLOW_rule__Details__Group__4__Impl_in_rule__Details__Group__42350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Details__Group__4__Impl2378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateProject__Group__0__Impl_in_rule__CreateProject__Group__02419 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__CreateProject__Group__1_in_rule__CreateProject__Group__02422 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__CreateProject__Group__0__Impl2450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateProject__Group__1__Impl_in_rule__CreateProject__Group__12481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateProject__ProjectNameAssignment_1_in_rule__CreateProject__Group__1__Impl2508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__0__Impl_in_rule__CreateModel__Group__02542 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__1_in_rule__CreateModel__Group__02545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__CreateModel__Group__0__Impl2573 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__1__Impl_in_rule__CreateModel__Group__12604 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__2_in_rule__CreateModel__Group__12607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__ModelNameAssignment_1_in_rule__CreateModel__Group__1__Impl2634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__2__Impl_in_rule__CreateModel__Group__22664 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__3_in_rule__CreateModel__Group__22667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__CreateModel__Group__2__Impl2695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__3__Impl_in_rule__CreateModel__Group__32726 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__4_in_rule__CreateModel__Group__32729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__PathAssignment_3_in_rule__CreateModel__Group__3__Impl2756 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__4__Impl_in_rule__CreateModel__Group__42786 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__5_in_rule__CreateModel__Group__42789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__CreateModel__Group__4__Impl2817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__5__Impl_in_rule__CreateModel__Group__52848 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__RootURIAssignment_5_in_rule__CreateModel__Group__5__Impl2875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Check__Group__0__Impl_in_rule__Check__Group__02917 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_rule__Check__Group__1_in_rule__Check__Group__02920 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Check__Group__0__Impl2948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Check__Group__1__Impl_in_rule__Check__Group__12979 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Scenario__NameAssignment_13046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProcessings_in_rule__Scenario__ProcessingsAssignment_33077 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__PropertiesView__NameAssignment_13108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubProcessings_in_rule__PropertiesView__ProcessingsAssignment_33139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Wizard__NameAssignment_13170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubProcessings_in_rule__Wizard__ProcessingsAssignment_33201 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Details__NameAssignment_13232 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubProcessings_in_rule__Details__ProcessingsAssignment_33263 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__CreateProject__ProjectNameAssignment_13294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__CreateModel__ModelNameAssignment_13325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__CreateModel__PathAssignment_33356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__CreateModel__RootURIAssignment_53387 = new BitSet(new long[]{0x0000000000000002L});
    }


}