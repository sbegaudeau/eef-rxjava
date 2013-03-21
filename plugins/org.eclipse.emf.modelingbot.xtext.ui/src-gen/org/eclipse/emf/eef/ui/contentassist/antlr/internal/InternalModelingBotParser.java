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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'scenario'", "'{'", "'}'", "'propertiesView'", "'wizard'", "'detailsPage'", "'createProject'", "'deleteProject'", "'createObject'", "':'", "'inResource'", "'at'", "'save'", "'check!'", "'inElement'", "'inFeature'", "'set'", "'values'", "','", "'usingWidget'"
    };
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
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


    // $ANTLR start "entryRuleRemoveProject"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:312:1: entryRuleRemoveProject : ruleRemoveProject EOF ;
    public final void entryRuleRemoveProject() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:313:1: ( ruleRemoveProject EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:314:1: ruleRemoveProject EOF
            {
             before(grammarAccess.getRemoveProjectRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRemoveProject_in_entryRuleRemoveProject601);
            ruleRemoveProject();

            state._fsp--;

             after(grammarAccess.getRemoveProjectRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRemoveProject608); 

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
    // $ANTLR end "entryRuleRemoveProject"


    // $ANTLR start "ruleRemoveProject"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:321:1: ruleRemoveProject : ( ( rule__RemoveProject__Group__0 ) ) ;
    public final void ruleRemoveProject() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:325:2: ( ( ( rule__RemoveProject__Group__0 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:326:1: ( ( rule__RemoveProject__Group__0 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:326:1: ( ( rule__RemoveProject__Group__0 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:327:1: ( rule__RemoveProject__Group__0 )
            {
             before(grammarAccess.getRemoveProjectAccess().getGroup()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:328:1: ( rule__RemoveProject__Group__0 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:328:2: rule__RemoveProject__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__RemoveProject__Group__0_in_ruleRemoveProject634);
            rule__RemoveProject__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRemoveProjectAccess().getGroup()); 

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
    // $ANTLR end "ruleRemoveProject"


    // $ANTLR start "entryRuleCreateModel"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:342:1: entryRuleCreateModel : ruleCreateModel EOF ;
    public final void entryRuleCreateModel() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:343:1: ( ruleCreateModel EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:344:1: ruleCreateModel EOF
            {
             before(grammarAccess.getCreateModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCreateModel_in_entryRuleCreateModel663);
            ruleCreateModel();

            state._fsp--;

             after(grammarAccess.getCreateModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCreateModel670); 

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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:351:1: ruleCreateModel : ( ( rule__CreateModel__Group__0 ) ) ;
    public final void ruleCreateModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:355:2: ( ( ( rule__CreateModel__Group__0 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:356:1: ( ( rule__CreateModel__Group__0 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:356:1: ( ( rule__CreateModel__Group__0 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:357:1: ( rule__CreateModel__Group__0 )
            {
             before(grammarAccess.getCreateModelAccess().getGroup()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:358:1: ( rule__CreateModel__Group__0 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:358:2: rule__CreateModel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__0_in_ruleCreateModel696);
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


    // $ANTLR start "entryRuleSave"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:370:1: entryRuleSave : ruleSave EOF ;
    public final void entryRuleSave() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:371:1: ( ruleSave EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:372:1: ruleSave EOF
            {
             before(grammarAccess.getSaveRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSave_in_entryRuleSave723);
            ruleSave();

            state._fsp--;

             after(grammarAccess.getSaveRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSave730); 

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
    // $ANTLR end "entryRuleSave"


    // $ANTLR start "ruleSave"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:379:1: ruleSave : ( ( rule__Save__Group__0 ) ) ;
    public final void ruleSave() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:383:2: ( ( ( rule__Save__Group__0 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:384:1: ( ( rule__Save__Group__0 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:384:1: ( ( rule__Save__Group__0 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:385:1: ( rule__Save__Group__0 )
            {
             before(grammarAccess.getSaveAccess().getGroup()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:386:1: ( rule__Save__Group__0 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:386:2: rule__Save__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Save__Group__0_in_ruleSave756);
            rule__Save__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSaveAccess().getGroup()); 

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
    // $ANTLR end "ruleSave"


    // $ANTLR start "entryRuleEEFAction"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:398:1: entryRuleEEFAction : ruleEEFAction EOF ;
    public final void entryRuleEEFAction() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:399:1: ( ruleEEFAction EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:400:1: ruleEEFAction EOF
            {
             before(grammarAccess.getEEFActionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEEFAction_in_entryRuleEEFAction783);
            ruleEEFAction();

            state._fsp--;

             after(grammarAccess.getEEFActionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEEFAction790); 

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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:407:1: ruleEEFAction : ( ( rule__EEFAction__Alternatives ) ) ;
    public final void ruleEEFAction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:411:2: ( ( ( rule__EEFAction__Alternatives ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:412:1: ( ( rule__EEFAction__Alternatives ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:412:1: ( ( rule__EEFAction__Alternatives ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:413:1: ( rule__EEFAction__Alternatives )
            {
             before(grammarAccess.getEEFActionAccess().getAlternatives()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:414:1: ( rule__EEFAction__Alternatives )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:414:2: rule__EEFAction__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EEFAction__Alternatives_in_ruleEEFAction816);
            rule__EEFAction__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEEFActionAccess().getAlternatives()); 

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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:426:1: entryRuleCheck : ruleCheck EOF ;
    public final void entryRuleCheck() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:427:1: ( ruleCheck EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:428:1: ruleCheck EOF
            {
             before(grammarAccess.getCheckRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCheck_in_entryRuleCheck843);
            ruleCheck();

            state._fsp--;

             after(grammarAccess.getCheckRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCheck850); 

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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:435:1: ruleCheck : ( ( rule__Check__Group__0 ) ) ;
    public final void ruleCheck() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:439:2: ( ( ( rule__Check__Group__0 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:440:1: ( ( rule__Check__Group__0 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:440:1: ( ( rule__Check__Group__0 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:441:1: ( rule__Check__Group__0 )
            {
             before(grammarAccess.getCheckAccess().getGroup()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:442:1: ( rule__Check__Group__0 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:442:2: rule__Check__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Check__Group__0_in_ruleCheck876);
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


    // $ANTLR start "entryRuleAdd"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:454:1: entryRuleAdd : ruleAdd EOF ;
    public final void entryRuleAdd() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:455:1: ( ruleAdd EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:456:1: ruleAdd EOF
            {
             before(grammarAccess.getAddRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAdd_in_entryRuleAdd903);
            ruleAdd();

            state._fsp--;

             after(grammarAccess.getAddRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAdd910); 

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
    // $ANTLR end "entryRuleAdd"


    // $ANTLR start "ruleAdd"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:463:1: ruleAdd : ( ( rule__Add__Group__0 ) ) ;
    public final void ruleAdd() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:467:2: ( ( ( rule__Add__Group__0 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:468:1: ( ( rule__Add__Group__0 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:468:1: ( ( rule__Add__Group__0 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:469:1: ( rule__Add__Group__0 )
            {
             before(grammarAccess.getAddAccess().getGroup()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:470:1: ( rule__Add__Group__0 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:470:2: rule__Add__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Add__Group__0_in_ruleAdd936);
            rule__Add__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAddAccess().getGroup()); 

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
    // $ANTLR end "ruleAdd"


    // $ANTLR start "entryRuleSetAttribute"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:482:1: entryRuleSetAttribute : ruleSetAttribute EOF ;
    public final void entryRuleSetAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:483:1: ( ruleSetAttribute EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:484:1: ruleSetAttribute EOF
            {
             before(grammarAccess.getSetAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSetAttribute_in_entryRuleSetAttribute963);
            ruleSetAttribute();

            state._fsp--;

             after(grammarAccess.getSetAttributeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSetAttribute970); 

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
    // $ANTLR end "entryRuleSetAttribute"


    // $ANTLR start "ruleSetAttribute"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:491:1: ruleSetAttribute : ( ( rule__SetAttribute__Group__0 ) ) ;
    public final void ruleSetAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:495:2: ( ( ( rule__SetAttribute__Group__0 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:496:1: ( ( rule__SetAttribute__Group__0 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:496:1: ( ( rule__SetAttribute__Group__0 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:497:1: ( rule__SetAttribute__Group__0 )
            {
             before(grammarAccess.getSetAttributeAccess().getGroup()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:498:1: ( rule__SetAttribute__Group__0 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:498:2: rule__SetAttribute__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group__0_in_ruleSetAttribute996);
            rule__SetAttribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSetAttributeAccess().getGroup()); 

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
    // $ANTLR end "ruleSetAttribute"


    // $ANTLR start "entryRuleEString"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:510:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:511:1: ( ruleEString EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:512:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString1023);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString1030); 

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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:519:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:523:2: ( ( ( rule__EString__Alternatives ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:524:1: ( ( rule__EString__Alternatives ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:524:1: ( ( rule__EString__Alternatives ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:525:1: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:526:1: ( rule__EString__Alternatives )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:526:2: rule__EString__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EString__Alternatives_in_ruleEString1056);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:538:1: rule__Processings__Alternatives : ( ( ruleDetails ) | ( ruleWizard ) | ( rulePropertiesView ) | ( ruleAction ) );
    public final void rule__Processings__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:542:1: ( ( ruleDetails ) | ( ruleWizard ) | ( rulePropertiesView ) | ( ruleAction ) )
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
            case 19:
            case 23:
            case 24:
            case 27:
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
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:543:1: ( ruleDetails )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:543:1: ( ruleDetails )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:544:1: ruleDetails
                    {
                     before(grammarAccess.getProcessingsAccess().getDetailsParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleDetails_in_rule__Processings__Alternatives1092);
                    ruleDetails();

                    state._fsp--;

                     after(grammarAccess.getProcessingsAccess().getDetailsParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:549:6: ( ruleWizard )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:549:6: ( ruleWizard )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:550:1: ruleWizard
                    {
                     before(grammarAccess.getProcessingsAccess().getWizardParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleWizard_in_rule__Processings__Alternatives1109);
                    ruleWizard();

                    state._fsp--;

                     after(grammarAccess.getProcessingsAccess().getWizardParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:555:6: ( rulePropertiesView )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:555:6: ( rulePropertiesView )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:556:1: rulePropertiesView
                    {
                     before(grammarAccess.getProcessingsAccess().getPropertiesViewParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_rulePropertiesView_in_rule__Processings__Alternatives1126);
                    rulePropertiesView();

                    state._fsp--;

                     after(grammarAccess.getProcessingsAccess().getPropertiesViewParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:561:6: ( ruleAction )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:561:6: ( ruleAction )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:562:1: ruleAction
                    {
                     before(grammarAccess.getProcessingsAccess().getActionParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAction_in_rule__Processings__Alternatives1143);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:572:1: rule__SubProcessings__Alternatives : ( ( ruleWizard ) | ( ruleDetails ) | ( rulePropertiesView ) | ( ruleAction ) );
    public final void rule__SubProcessings__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:576:1: ( ( ruleWizard ) | ( ruleDetails ) | ( rulePropertiesView ) | ( ruleAction ) )
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
            case 19:
            case 23:
            case 24:
            case 27:
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
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:577:1: ( ruleWizard )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:577:1: ( ruleWizard )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:578:1: ruleWizard
                    {
                     before(grammarAccess.getSubProcessingsAccess().getWizardParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleWizard_in_rule__SubProcessings__Alternatives1175);
                    ruleWizard();

                    state._fsp--;

                     after(grammarAccess.getSubProcessingsAccess().getWizardParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:583:6: ( ruleDetails )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:583:6: ( ruleDetails )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:584:1: ruleDetails
                    {
                     before(grammarAccess.getSubProcessingsAccess().getDetailsParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleDetails_in_rule__SubProcessings__Alternatives1192);
                    ruleDetails();

                    state._fsp--;

                     after(grammarAccess.getSubProcessingsAccess().getDetailsParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:589:6: ( rulePropertiesView )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:589:6: ( rulePropertiesView )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:590:1: rulePropertiesView
                    {
                     before(grammarAccess.getSubProcessingsAccess().getPropertiesViewParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_rulePropertiesView_in_rule__SubProcessings__Alternatives1209);
                    rulePropertiesView();

                    state._fsp--;

                     after(grammarAccess.getSubProcessingsAccess().getPropertiesViewParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:595:6: ( ruleAction )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:595:6: ( ruleAction )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:596:1: ruleAction
                    {
                     before(grammarAccess.getSubProcessingsAccess().getActionParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAction_in_rule__SubProcessings__Alternatives1226);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:606:1: rule__Action__Alternatives : ( ( ruleEclipseAction ) | ( ruleEEFAction ) );
    public final void rule__Action__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:610:1: ( ( ruleEclipseAction ) | ( ruleEEFAction ) )
            int alt3=2;
            switch ( input.LA(1) ) {
            case 17:
            case 18:
            case 23:
                {
                alt3=1;
                }
                break;
            case 19:
                {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==RULE_ID) ) {
                    int LA3_4 = input.LA(3);

                    if ( (LA3_4==20) ) {
                        int LA3_5 = input.LA(4);

                        if ( (LA3_5==RULE_STRING) ) {
                            int LA3_6 = input.LA(5);

                            if ( (LA3_6==25) ) {
                                alt3=2;
                            }
                            else if ( (LA3_6==21) ) {
                                alt3=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 6, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA3_5==RULE_ID) ) {
                            int LA3_7 = input.LA(5);

                            if ( (LA3_7==21) ) {
                                alt3=1;
                            }
                            else if ( (LA3_7==25) ) {
                                alt3=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 7, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
                }
                break;
            case 24:
            case 27:
                {
                alt3=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:611:1: ( ruleEclipseAction )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:611:1: ( ruleEclipseAction )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:612:1: ruleEclipseAction
                    {
                     before(grammarAccess.getActionAccess().getEclipseActionParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleEclipseAction_in_rule__Action__Alternatives1258);
                    ruleEclipseAction();

                    state._fsp--;

                     after(grammarAccess.getActionAccess().getEclipseActionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:617:6: ( ruleEEFAction )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:617:6: ( ruleEEFAction )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:618:1: ruleEEFAction
                    {
                     before(grammarAccess.getActionAccess().getEEFActionParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleEEFAction_in_rule__Action__Alternatives1275);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:628:1: rule__EclipseAction__Alternatives : ( ( ruleCreateProject ) | ( ruleCreateModel ) | ( ruleSave ) | ( ruleRemoveProject ) );
    public final void rule__EclipseAction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:632:1: ( ( ruleCreateProject ) | ( ruleCreateModel ) | ( ruleSave ) | ( ruleRemoveProject ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt4=1;
                }
                break;
            case 19:
                {
                alt4=2;
                }
                break;
            case 23:
                {
                alt4=3;
                }
                break;
            case 18:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:633:1: ( ruleCreateProject )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:633:1: ( ruleCreateProject )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:634:1: ruleCreateProject
                    {
                     before(grammarAccess.getEclipseActionAccess().getCreateProjectParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleCreateProject_in_rule__EclipseAction__Alternatives1307);
                    ruleCreateProject();

                    state._fsp--;

                     after(grammarAccess.getEclipseActionAccess().getCreateProjectParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:639:6: ( ruleCreateModel )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:639:6: ( ruleCreateModel )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:640:1: ruleCreateModel
                    {
                     before(grammarAccess.getEclipseActionAccess().getCreateModelParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleCreateModel_in_rule__EclipseAction__Alternatives1324);
                    ruleCreateModel();

                    state._fsp--;

                     after(grammarAccess.getEclipseActionAccess().getCreateModelParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:645:6: ( ruleSave )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:645:6: ( ruleSave )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:646:1: ruleSave
                    {
                     before(grammarAccess.getEclipseActionAccess().getSaveParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleSave_in_rule__EclipseAction__Alternatives1341);
                    ruleSave();

                    state._fsp--;

                     after(grammarAccess.getEclipseActionAccess().getSaveParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:651:6: ( ruleRemoveProject )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:651:6: ( ruleRemoveProject )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:652:1: ruleRemoveProject
                    {
                     before(grammarAccess.getEclipseActionAccess().getRemoveProjectParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_ruleRemoveProject_in_rule__EclipseAction__Alternatives1358);
                    ruleRemoveProject();

                    state._fsp--;

                     after(grammarAccess.getEclipseActionAccess().getRemoveProjectParserRuleCall_3()); 

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


    // $ANTLR start "rule__EEFAction__Alternatives"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:663:1: rule__EEFAction__Alternatives : ( ( ruleCheck ) | ( ruleAdd ) | ( ruleSetAttribute ) );
    public final void rule__EEFAction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:667:1: ( ( ruleCheck ) | ( ruleAdd ) | ( ruleSetAttribute ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt5=1;
                }
                break;
            case 19:
                {
                alt5=2;
                }
                break;
            case 27:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:668:1: ( ruleCheck )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:668:1: ( ruleCheck )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:669:1: ruleCheck
                    {
                     before(grammarAccess.getEEFActionAccess().getCheckParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleCheck_in_rule__EEFAction__Alternatives1391);
                    ruleCheck();

                    state._fsp--;

                     after(grammarAccess.getEEFActionAccess().getCheckParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:674:6: ( ruleAdd )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:674:6: ( ruleAdd )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:675:1: ruleAdd
                    {
                     before(grammarAccess.getEEFActionAccess().getAddParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAdd_in_rule__EEFAction__Alternatives1408);
                    ruleAdd();

                    state._fsp--;

                     after(grammarAccess.getEEFActionAccess().getAddParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:680:6: ( ruleSetAttribute )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:680:6: ( ruleSetAttribute )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:681:1: ruleSetAttribute
                    {
                     before(grammarAccess.getEEFActionAccess().getSetAttributeParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleSetAttribute_in_rule__EEFAction__Alternatives1425);
                    ruleSetAttribute();

                    state._fsp--;

                     after(grammarAccess.getEEFActionAccess().getSetAttributeParserRuleCall_2()); 

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
    // $ANTLR end "rule__EEFAction__Alternatives"


    // $ANTLR start "rule__EString__Alternatives"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:691:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:695:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:696:1: ( RULE_STRING )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:696:1: ( RULE_STRING )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:697:1: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EString__Alternatives1457); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:702:6: ( RULE_ID )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:702:6: ( RULE_ID )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:703:1: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EString__Alternatives1474); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:715:1: rule__Scenario__Group__0 : rule__Scenario__Group__0__Impl rule__Scenario__Group__1 ;
    public final void rule__Scenario__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:719:1: ( rule__Scenario__Group__0__Impl rule__Scenario__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:720:2: rule__Scenario__Group__0__Impl rule__Scenario__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__0__Impl_in_rule__Scenario__Group__01504);
            rule__Scenario__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__1_in_rule__Scenario__Group__01507);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:727:1: rule__Scenario__Group__0__Impl : ( 'scenario' ) ;
    public final void rule__Scenario__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:731:1: ( ( 'scenario' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:732:1: ( 'scenario' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:732:1: ( 'scenario' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:733:1: 'scenario'
            {
             before(grammarAccess.getScenarioAccess().getScenarioKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Scenario__Group__0__Impl1535); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:746:1: rule__Scenario__Group__1 : rule__Scenario__Group__1__Impl rule__Scenario__Group__2 ;
    public final void rule__Scenario__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:750:1: ( rule__Scenario__Group__1__Impl rule__Scenario__Group__2 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:751:2: rule__Scenario__Group__1__Impl rule__Scenario__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__1__Impl_in_rule__Scenario__Group__11566);
            rule__Scenario__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__2_in_rule__Scenario__Group__11569);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:758:1: rule__Scenario__Group__1__Impl : ( ( rule__Scenario__NameAssignment_1 ) ) ;
    public final void rule__Scenario__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:762:1: ( ( ( rule__Scenario__NameAssignment_1 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:763:1: ( ( rule__Scenario__NameAssignment_1 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:763:1: ( ( rule__Scenario__NameAssignment_1 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:764:1: ( rule__Scenario__NameAssignment_1 )
            {
             before(grammarAccess.getScenarioAccess().getNameAssignment_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:765:1: ( rule__Scenario__NameAssignment_1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:765:2: rule__Scenario__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario__NameAssignment_1_in_rule__Scenario__Group__1__Impl1596);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:775:1: rule__Scenario__Group__2 : rule__Scenario__Group__2__Impl rule__Scenario__Group__3 ;
    public final void rule__Scenario__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:779:1: ( rule__Scenario__Group__2__Impl rule__Scenario__Group__3 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:780:2: rule__Scenario__Group__2__Impl rule__Scenario__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__2__Impl_in_rule__Scenario__Group__21626);
            rule__Scenario__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__3_in_rule__Scenario__Group__21629);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:787:1: rule__Scenario__Group__2__Impl : ( '{' ) ;
    public final void rule__Scenario__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:791:1: ( ( '{' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:792:1: ( '{' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:792:1: ( '{' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:793:1: '{'
            {
             before(grammarAccess.getScenarioAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Scenario__Group__2__Impl1657); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:806:1: rule__Scenario__Group__3 : rule__Scenario__Group__3__Impl rule__Scenario__Group__4 ;
    public final void rule__Scenario__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:810:1: ( rule__Scenario__Group__3__Impl rule__Scenario__Group__4 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:811:2: rule__Scenario__Group__3__Impl rule__Scenario__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__3__Impl_in_rule__Scenario__Group__31688);
            rule__Scenario__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__4_in_rule__Scenario__Group__31691);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:818:1: rule__Scenario__Group__3__Impl : ( ( rule__Scenario__ProcessingsAssignment_3 )* ) ;
    public final void rule__Scenario__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:822:1: ( ( ( rule__Scenario__ProcessingsAssignment_3 )* ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:823:1: ( ( rule__Scenario__ProcessingsAssignment_3 )* )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:823:1: ( ( rule__Scenario__ProcessingsAssignment_3 )* )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:824:1: ( rule__Scenario__ProcessingsAssignment_3 )*
            {
             before(grammarAccess.getScenarioAccess().getProcessingsAssignment_3()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:825:1: ( rule__Scenario__ProcessingsAssignment_3 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=14 && LA7_0<=19)||(LA7_0>=23 && LA7_0<=24)||LA7_0==27) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:825:2: rule__Scenario__ProcessingsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Scenario__ProcessingsAssignment_3_in_rule__Scenario__Group__3__Impl1718);
            	    rule__Scenario__ProcessingsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:835:1: rule__Scenario__Group__4 : rule__Scenario__Group__4__Impl ;
    public final void rule__Scenario__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:839:1: ( rule__Scenario__Group__4__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:840:2: rule__Scenario__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__4__Impl_in_rule__Scenario__Group__41749);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:846:1: rule__Scenario__Group__4__Impl : ( '}' ) ;
    public final void rule__Scenario__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:850:1: ( ( '}' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:851:1: ( '}' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:851:1: ( '}' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:852:1: '}'
            {
             before(grammarAccess.getScenarioAccess().getRightCurlyBracketKeyword_4()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Scenario__Group__4__Impl1777); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:875:1: rule__PropertiesView__Group__0 : rule__PropertiesView__Group__0__Impl rule__PropertiesView__Group__1 ;
    public final void rule__PropertiesView__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:879:1: ( rule__PropertiesView__Group__0__Impl rule__PropertiesView__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:880:2: rule__PropertiesView__Group__0__Impl rule__PropertiesView__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__0__Impl_in_rule__PropertiesView__Group__01818);
            rule__PropertiesView__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__1_in_rule__PropertiesView__Group__01821);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:887:1: rule__PropertiesView__Group__0__Impl : ( 'propertiesView' ) ;
    public final void rule__PropertiesView__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:891:1: ( ( 'propertiesView' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:892:1: ( 'propertiesView' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:892:1: ( 'propertiesView' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:893:1: 'propertiesView'
            {
             before(grammarAccess.getPropertiesViewAccess().getPropertiesViewKeyword_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__PropertiesView__Group__0__Impl1849); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:906:1: rule__PropertiesView__Group__1 : rule__PropertiesView__Group__1__Impl rule__PropertiesView__Group__2 ;
    public final void rule__PropertiesView__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:910:1: ( rule__PropertiesView__Group__1__Impl rule__PropertiesView__Group__2 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:911:2: rule__PropertiesView__Group__1__Impl rule__PropertiesView__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__1__Impl_in_rule__PropertiesView__Group__11880);
            rule__PropertiesView__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__2_in_rule__PropertiesView__Group__11883);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:918:1: rule__PropertiesView__Group__1__Impl : ( ( rule__PropertiesView__NameAssignment_1 )? ) ;
    public final void rule__PropertiesView__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:922:1: ( ( ( rule__PropertiesView__NameAssignment_1 )? ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:923:1: ( ( rule__PropertiesView__NameAssignment_1 )? )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:923:1: ( ( rule__PropertiesView__NameAssignment_1 )? )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:924:1: ( rule__PropertiesView__NameAssignment_1 )?
            {
             before(grammarAccess.getPropertiesViewAccess().getNameAssignment_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:925:1: ( rule__PropertiesView__NameAssignment_1 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_STRING && LA8_0<=RULE_ID)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:925:2: rule__PropertiesView__NameAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__NameAssignment_1_in_rule__PropertiesView__Group__1__Impl1910);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:935:1: rule__PropertiesView__Group__2 : rule__PropertiesView__Group__2__Impl rule__PropertiesView__Group__3 ;
    public final void rule__PropertiesView__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:939:1: ( rule__PropertiesView__Group__2__Impl rule__PropertiesView__Group__3 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:940:2: rule__PropertiesView__Group__2__Impl rule__PropertiesView__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__2__Impl_in_rule__PropertiesView__Group__21941);
            rule__PropertiesView__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__3_in_rule__PropertiesView__Group__21944);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:947:1: rule__PropertiesView__Group__2__Impl : ( '{' ) ;
    public final void rule__PropertiesView__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:951:1: ( ( '{' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:952:1: ( '{' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:952:1: ( '{' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:953:1: '{'
            {
             before(grammarAccess.getPropertiesViewAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__PropertiesView__Group__2__Impl1972); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:966:1: rule__PropertiesView__Group__3 : rule__PropertiesView__Group__3__Impl rule__PropertiesView__Group__4 ;
    public final void rule__PropertiesView__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:970:1: ( rule__PropertiesView__Group__3__Impl rule__PropertiesView__Group__4 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:971:2: rule__PropertiesView__Group__3__Impl rule__PropertiesView__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__3__Impl_in_rule__PropertiesView__Group__32003);
            rule__PropertiesView__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__4_in_rule__PropertiesView__Group__32006);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:978:1: rule__PropertiesView__Group__3__Impl : ( ( rule__PropertiesView__ProcessingsAssignment_3 )* ) ;
    public final void rule__PropertiesView__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:982:1: ( ( ( rule__PropertiesView__ProcessingsAssignment_3 )* ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:983:1: ( ( rule__PropertiesView__ProcessingsAssignment_3 )* )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:983:1: ( ( rule__PropertiesView__ProcessingsAssignment_3 )* )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:984:1: ( rule__PropertiesView__ProcessingsAssignment_3 )*
            {
             before(grammarAccess.getPropertiesViewAccess().getProcessingsAssignment_3()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:985:1: ( rule__PropertiesView__ProcessingsAssignment_3 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=14 && LA9_0<=19)||(LA9_0>=23 && LA9_0<=24)||LA9_0==27) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:985:2: rule__PropertiesView__ProcessingsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__ProcessingsAssignment_3_in_rule__PropertiesView__Group__3__Impl2033);
            	    rule__PropertiesView__ProcessingsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:995:1: rule__PropertiesView__Group__4 : rule__PropertiesView__Group__4__Impl ;
    public final void rule__PropertiesView__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:999:1: ( rule__PropertiesView__Group__4__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1000:2: rule__PropertiesView__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__4__Impl_in_rule__PropertiesView__Group__42064);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1006:1: rule__PropertiesView__Group__4__Impl : ( '}' ) ;
    public final void rule__PropertiesView__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1010:1: ( ( '}' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1011:1: ( '}' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1011:1: ( '}' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1012:1: '}'
            {
             before(grammarAccess.getPropertiesViewAccess().getRightCurlyBracketKeyword_4()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__PropertiesView__Group__4__Impl2092); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1035:1: rule__Wizard__Group__0 : rule__Wizard__Group__0__Impl rule__Wizard__Group__1 ;
    public final void rule__Wizard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1039:1: ( rule__Wizard__Group__0__Impl rule__Wizard__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1040:2: rule__Wizard__Group__0__Impl rule__Wizard__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__0__Impl_in_rule__Wizard__Group__02133);
            rule__Wizard__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__1_in_rule__Wizard__Group__02136);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1047:1: rule__Wizard__Group__0__Impl : ( 'wizard' ) ;
    public final void rule__Wizard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1051:1: ( ( 'wizard' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1052:1: ( 'wizard' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1052:1: ( 'wizard' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1053:1: 'wizard'
            {
             before(grammarAccess.getWizardAccess().getWizardKeyword_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Wizard__Group__0__Impl2164); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1066:1: rule__Wizard__Group__1 : rule__Wizard__Group__1__Impl rule__Wizard__Group__2 ;
    public final void rule__Wizard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1070:1: ( rule__Wizard__Group__1__Impl rule__Wizard__Group__2 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1071:2: rule__Wizard__Group__1__Impl rule__Wizard__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__1__Impl_in_rule__Wizard__Group__12195);
            rule__Wizard__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__2_in_rule__Wizard__Group__12198);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1078:1: rule__Wizard__Group__1__Impl : ( ( rule__Wizard__NameAssignment_1 )? ) ;
    public final void rule__Wizard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1082:1: ( ( ( rule__Wizard__NameAssignment_1 )? ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1083:1: ( ( rule__Wizard__NameAssignment_1 )? )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1083:1: ( ( rule__Wizard__NameAssignment_1 )? )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1084:1: ( rule__Wizard__NameAssignment_1 )?
            {
             before(grammarAccess.getWizardAccess().getNameAssignment_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1085:1: ( rule__Wizard__NameAssignment_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=RULE_STRING && LA10_0<=RULE_ID)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1085:2: rule__Wizard__NameAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Wizard__NameAssignment_1_in_rule__Wizard__Group__1__Impl2225);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1095:1: rule__Wizard__Group__2 : rule__Wizard__Group__2__Impl rule__Wizard__Group__3 ;
    public final void rule__Wizard__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1099:1: ( rule__Wizard__Group__2__Impl rule__Wizard__Group__3 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1100:2: rule__Wizard__Group__2__Impl rule__Wizard__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__2__Impl_in_rule__Wizard__Group__22256);
            rule__Wizard__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__3_in_rule__Wizard__Group__22259);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1107:1: rule__Wizard__Group__2__Impl : ( '{' ) ;
    public final void rule__Wizard__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1111:1: ( ( '{' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1112:1: ( '{' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1112:1: ( '{' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1113:1: '{'
            {
             before(grammarAccess.getWizardAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Wizard__Group__2__Impl2287); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1126:1: rule__Wizard__Group__3 : rule__Wizard__Group__3__Impl rule__Wizard__Group__4 ;
    public final void rule__Wizard__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1130:1: ( rule__Wizard__Group__3__Impl rule__Wizard__Group__4 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1131:2: rule__Wizard__Group__3__Impl rule__Wizard__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__3__Impl_in_rule__Wizard__Group__32318);
            rule__Wizard__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__4_in_rule__Wizard__Group__32321);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1138:1: rule__Wizard__Group__3__Impl : ( ( rule__Wizard__ProcessingsAssignment_3 )* ) ;
    public final void rule__Wizard__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1142:1: ( ( ( rule__Wizard__ProcessingsAssignment_3 )* ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1143:1: ( ( rule__Wizard__ProcessingsAssignment_3 )* )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1143:1: ( ( rule__Wizard__ProcessingsAssignment_3 )* )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1144:1: ( rule__Wizard__ProcessingsAssignment_3 )*
            {
             before(grammarAccess.getWizardAccess().getProcessingsAssignment_3()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1145:1: ( rule__Wizard__ProcessingsAssignment_3 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=14 && LA11_0<=19)||(LA11_0>=23 && LA11_0<=24)||LA11_0==27) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1145:2: rule__Wizard__ProcessingsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Wizard__ProcessingsAssignment_3_in_rule__Wizard__Group__3__Impl2348);
            	    rule__Wizard__ProcessingsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1155:1: rule__Wizard__Group__4 : rule__Wizard__Group__4__Impl ;
    public final void rule__Wizard__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1159:1: ( rule__Wizard__Group__4__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1160:2: rule__Wizard__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__4__Impl_in_rule__Wizard__Group__42379);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1166:1: rule__Wizard__Group__4__Impl : ( '}' ) ;
    public final void rule__Wizard__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1170:1: ( ( '}' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1171:1: ( '}' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1171:1: ( '}' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1172:1: '}'
            {
             before(grammarAccess.getWizardAccess().getRightCurlyBracketKeyword_4()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Wizard__Group__4__Impl2407); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1195:1: rule__Details__Group__0 : rule__Details__Group__0__Impl rule__Details__Group__1 ;
    public final void rule__Details__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1199:1: ( rule__Details__Group__0__Impl rule__Details__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1200:2: rule__Details__Group__0__Impl rule__Details__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__0__Impl_in_rule__Details__Group__02448);
            rule__Details__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__1_in_rule__Details__Group__02451);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1207:1: rule__Details__Group__0__Impl : ( 'detailsPage' ) ;
    public final void rule__Details__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1211:1: ( ( 'detailsPage' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1212:1: ( 'detailsPage' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1212:1: ( 'detailsPage' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1213:1: 'detailsPage'
            {
             before(grammarAccess.getDetailsAccess().getDetailsPageKeyword_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Details__Group__0__Impl2479); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1226:1: rule__Details__Group__1 : rule__Details__Group__1__Impl rule__Details__Group__2 ;
    public final void rule__Details__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1230:1: ( rule__Details__Group__1__Impl rule__Details__Group__2 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1231:2: rule__Details__Group__1__Impl rule__Details__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__1__Impl_in_rule__Details__Group__12510);
            rule__Details__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__2_in_rule__Details__Group__12513);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1238:1: rule__Details__Group__1__Impl : ( ( rule__Details__NameAssignment_1 )? ) ;
    public final void rule__Details__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1242:1: ( ( ( rule__Details__NameAssignment_1 )? ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1243:1: ( ( rule__Details__NameAssignment_1 )? )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1243:1: ( ( rule__Details__NameAssignment_1 )? )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1244:1: ( rule__Details__NameAssignment_1 )?
            {
             before(grammarAccess.getDetailsAccess().getNameAssignment_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1245:1: ( rule__Details__NameAssignment_1 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=RULE_STRING && LA12_0<=RULE_ID)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1245:2: rule__Details__NameAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Details__NameAssignment_1_in_rule__Details__Group__1__Impl2540);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1255:1: rule__Details__Group__2 : rule__Details__Group__2__Impl rule__Details__Group__3 ;
    public final void rule__Details__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1259:1: ( rule__Details__Group__2__Impl rule__Details__Group__3 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1260:2: rule__Details__Group__2__Impl rule__Details__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__2__Impl_in_rule__Details__Group__22571);
            rule__Details__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__3_in_rule__Details__Group__22574);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1267:1: rule__Details__Group__2__Impl : ( '{' ) ;
    public final void rule__Details__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1271:1: ( ( '{' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1272:1: ( '{' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1272:1: ( '{' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1273:1: '{'
            {
             before(grammarAccess.getDetailsAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Details__Group__2__Impl2602); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1286:1: rule__Details__Group__3 : rule__Details__Group__3__Impl rule__Details__Group__4 ;
    public final void rule__Details__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1290:1: ( rule__Details__Group__3__Impl rule__Details__Group__4 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1291:2: rule__Details__Group__3__Impl rule__Details__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__3__Impl_in_rule__Details__Group__32633);
            rule__Details__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__4_in_rule__Details__Group__32636);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1298:1: rule__Details__Group__3__Impl : ( ( rule__Details__ProcessingsAssignment_3 )* ) ;
    public final void rule__Details__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1302:1: ( ( ( rule__Details__ProcessingsAssignment_3 )* ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1303:1: ( ( rule__Details__ProcessingsAssignment_3 )* )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1303:1: ( ( rule__Details__ProcessingsAssignment_3 )* )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1304:1: ( rule__Details__ProcessingsAssignment_3 )*
            {
             before(grammarAccess.getDetailsAccess().getProcessingsAssignment_3()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1305:1: ( rule__Details__ProcessingsAssignment_3 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=14 && LA13_0<=19)||(LA13_0>=23 && LA13_0<=24)||LA13_0==27) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1305:2: rule__Details__ProcessingsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Details__ProcessingsAssignment_3_in_rule__Details__Group__3__Impl2663);
            	    rule__Details__ProcessingsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1315:1: rule__Details__Group__4 : rule__Details__Group__4__Impl ;
    public final void rule__Details__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1319:1: ( rule__Details__Group__4__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1320:2: rule__Details__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__4__Impl_in_rule__Details__Group__42694);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1326:1: rule__Details__Group__4__Impl : ( '}' ) ;
    public final void rule__Details__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1330:1: ( ( '}' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1331:1: ( '}' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1331:1: ( '}' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1332:1: '}'
            {
             before(grammarAccess.getDetailsAccess().getRightCurlyBracketKeyword_4()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Details__Group__4__Impl2722); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1355:1: rule__CreateProject__Group__0 : rule__CreateProject__Group__0__Impl rule__CreateProject__Group__1 ;
    public final void rule__CreateProject__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1359:1: ( rule__CreateProject__Group__0__Impl rule__CreateProject__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1360:2: rule__CreateProject__Group__0__Impl rule__CreateProject__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateProject__Group__0__Impl_in_rule__CreateProject__Group__02763);
            rule__CreateProject__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CreateProject__Group__1_in_rule__CreateProject__Group__02766);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1367:1: rule__CreateProject__Group__0__Impl : ( 'createProject' ) ;
    public final void rule__CreateProject__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1371:1: ( ( 'createProject' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1372:1: ( 'createProject' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1372:1: ( 'createProject' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1373:1: 'createProject'
            {
             before(grammarAccess.getCreateProjectAccess().getCreateProjectKeyword_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__CreateProject__Group__0__Impl2794); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1386:1: rule__CreateProject__Group__1 : rule__CreateProject__Group__1__Impl ;
    public final void rule__CreateProject__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1390:1: ( rule__CreateProject__Group__1__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1391:2: rule__CreateProject__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateProject__Group__1__Impl_in_rule__CreateProject__Group__12825);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1397:1: rule__CreateProject__Group__1__Impl : ( ( rule__CreateProject__ProjectNameAssignment_1 ) ) ;
    public final void rule__CreateProject__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1401:1: ( ( ( rule__CreateProject__ProjectNameAssignment_1 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1402:1: ( ( rule__CreateProject__ProjectNameAssignment_1 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1402:1: ( ( rule__CreateProject__ProjectNameAssignment_1 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1403:1: ( rule__CreateProject__ProjectNameAssignment_1 )
            {
             before(grammarAccess.getCreateProjectAccess().getProjectNameAssignment_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1404:1: ( rule__CreateProject__ProjectNameAssignment_1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1404:2: rule__CreateProject__ProjectNameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateProject__ProjectNameAssignment_1_in_rule__CreateProject__Group__1__Impl2852);
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


    // $ANTLR start "rule__RemoveProject__Group__0"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1418:1: rule__RemoveProject__Group__0 : rule__RemoveProject__Group__0__Impl rule__RemoveProject__Group__1 ;
    public final void rule__RemoveProject__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1422:1: ( rule__RemoveProject__Group__0__Impl rule__RemoveProject__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1423:2: rule__RemoveProject__Group__0__Impl rule__RemoveProject__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__RemoveProject__Group__0__Impl_in_rule__RemoveProject__Group__02886);
            rule__RemoveProject__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__RemoveProject__Group__1_in_rule__RemoveProject__Group__02889);
            rule__RemoveProject__Group__1();

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
    // $ANTLR end "rule__RemoveProject__Group__0"


    // $ANTLR start "rule__RemoveProject__Group__0__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1430:1: rule__RemoveProject__Group__0__Impl : ( 'deleteProject' ) ;
    public final void rule__RemoveProject__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1434:1: ( ( 'deleteProject' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1435:1: ( 'deleteProject' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1435:1: ( 'deleteProject' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1436:1: 'deleteProject'
            {
             before(grammarAccess.getRemoveProjectAccess().getDeleteProjectKeyword_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__RemoveProject__Group__0__Impl2917); 
             after(grammarAccess.getRemoveProjectAccess().getDeleteProjectKeyword_0()); 

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
    // $ANTLR end "rule__RemoveProject__Group__0__Impl"


    // $ANTLR start "rule__RemoveProject__Group__1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1449:1: rule__RemoveProject__Group__1 : rule__RemoveProject__Group__1__Impl ;
    public final void rule__RemoveProject__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1453:1: ( rule__RemoveProject__Group__1__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1454:2: rule__RemoveProject__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__RemoveProject__Group__1__Impl_in_rule__RemoveProject__Group__12948);
            rule__RemoveProject__Group__1__Impl();

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
    // $ANTLR end "rule__RemoveProject__Group__1"


    // $ANTLR start "rule__RemoveProject__Group__1__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1460:1: rule__RemoveProject__Group__1__Impl : ( ( rule__RemoveProject__ProjectNameAssignment_1 ) ) ;
    public final void rule__RemoveProject__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1464:1: ( ( ( rule__RemoveProject__ProjectNameAssignment_1 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1465:1: ( ( rule__RemoveProject__ProjectNameAssignment_1 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1465:1: ( ( rule__RemoveProject__ProjectNameAssignment_1 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1466:1: ( rule__RemoveProject__ProjectNameAssignment_1 )
            {
             before(grammarAccess.getRemoveProjectAccess().getProjectNameAssignment_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1467:1: ( rule__RemoveProject__ProjectNameAssignment_1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1467:2: rule__RemoveProject__ProjectNameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__RemoveProject__ProjectNameAssignment_1_in_rule__RemoveProject__Group__1__Impl2975);
            rule__RemoveProject__ProjectNameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRemoveProjectAccess().getProjectNameAssignment_1()); 

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
    // $ANTLR end "rule__RemoveProject__Group__1__Impl"


    // $ANTLR start "rule__CreateModel__Group__0"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1481:1: rule__CreateModel__Group__0 : rule__CreateModel__Group__0__Impl rule__CreateModel__Group__1 ;
    public final void rule__CreateModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1485:1: ( rule__CreateModel__Group__0__Impl rule__CreateModel__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1486:2: rule__CreateModel__Group__0__Impl rule__CreateModel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__0__Impl_in_rule__CreateModel__Group__03009);
            rule__CreateModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__1_in_rule__CreateModel__Group__03012);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1493:1: rule__CreateModel__Group__0__Impl : ( 'createObject' ) ;
    public final void rule__CreateModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1497:1: ( ( 'createObject' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1498:1: ( 'createObject' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1498:1: ( 'createObject' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1499:1: 'createObject'
            {
             before(grammarAccess.getCreateModelAccess().getCreateObjectKeyword_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__CreateModel__Group__0__Impl3040); 
             after(grammarAccess.getCreateModelAccess().getCreateObjectKeyword_0()); 

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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1512:1: rule__CreateModel__Group__1 : rule__CreateModel__Group__1__Impl rule__CreateModel__Group__2 ;
    public final void rule__CreateModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1516:1: ( rule__CreateModel__Group__1__Impl rule__CreateModel__Group__2 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1517:2: rule__CreateModel__Group__1__Impl rule__CreateModel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__1__Impl_in_rule__CreateModel__Group__13071);
            rule__CreateModel__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__2_in_rule__CreateModel__Group__13074);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1524:1: rule__CreateModel__Group__1__Impl : ( ( rule__CreateModel__ReferenceNameAssignment_1 ) ) ;
    public final void rule__CreateModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1528:1: ( ( ( rule__CreateModel__ReferenceNameAssignment_1 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1529:1: ( ( rule__CreateModel__ReferenceNameAssignment_1 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1529:1: ( ( rule__CreateModel__ReferenceNameAssignment_1 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1530:1: ( rule__CreateModel__ReferenceNameAssignment_1 )
            {
             before(grammarAccess.getCreateModelAccess().getReferenceNameAssignment_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1531:1: ( rule__CreateModel__ReferenceNameAssignment_1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1531:2: rule__CreateModel__ReferenceNameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__ReferenceNameAssignment_1_in_rule__CreateModel__Group__1__Impl3101);
            rule__CreateModel__ReferenceNameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCreateModelAccess().getReferenceNameAssignment_1()); 

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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1541:1: rule__CreateModel__Group__2 : rule__CreateModel__Group__2__Impl rule__CreateModel__Group__3 ;
    public final void rule__CreateModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1545:1: ( rule__CreateModel__Group__2__Impl rule__CreateModel__Group__3 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1546:2: rule__CreateModel__Group__2__Impl rule__CreateModel__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__2__Impl_in_rule__CreateModel__Group__23131);
            rule__CreateModel__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__3_in_rule__CreateModel__Group__23134);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1553:1: rule__CreateModel__Group__2__Impl : ( ':' ) ;
    public final void rule__CreateModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1557:1: ( ( ':' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1558:1: ( ':' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1558:1: ( ':' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1559:1: ':'
            {
             before(grammarAccess.getCreateModelAccess().getColonKeyword_2()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__CreateModel__Group__2__Impl3162); 
             after(grammarAccess.getCreateModelAccess().getColonKeyword_2()); 

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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1572:1: rule__CreateModel__Group__3 : rule__CreateModel__Group__3__Impl rule__CreateModel__Group__4 ;
    public final void rule__CreateModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1576:1: ( rule__CreateModel__Group__3__Impl rule__CreateModel__Group__4 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1577:2: rule__CreateModel__Group__3__Impl rule__CreateModel__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__3__Impl_in_rule__CreateModel__Group__33193);
            rule__CreateModel__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__4_in_rule__CreateModel__Group__33196);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1584:1: rule__CreateModel__Group__3__Impl : ( ( rule__CreateModel__RootURIAssignment_3 ) ) ;
    public final void rule__CreateModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1588:1: ( ( ( rule__CreateModel__RootURIAssignment_3 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1589:1: ( ( rule__CreateModel__RootURIAssignment_3 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1589:1: ( ( rule__CreateModel__RootURIAssignment_3 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1590:1: ( rule__CreateModel__RootURIAssignment_3 )
            {
             before(grammarAccess.getCreateModelAccess().getRootURIAssignment_3()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1591:1: ( rule__CreateModel__RootURIAssignment_3 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1591:2: rule__CreateModel__RootURIAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__RootURIAssignment_3_in_rule__CreateModel__Group__3__Impl3223);
            rule__CreateModel__RootURIAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCreateModelAccess().getRootURIAssignment_3()); 

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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1601:1: rule__CreateModel__Group__4 : rule__CreateModel__Group__4__Impl rule__CreateModel__Group__5 ;
    public final void rule__CreateModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1605:1: ( rule__CreateModel__Group__4__Impl rule__CreateModel__Group__5 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1606:2: rule__CreateModel__Group__4__Impl rule__CreateModel__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__4__Impl_in_rule__CreateModel__Group__43253);
            rule__CreateModel__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__5_in_rule__CreateModel__Group__43256);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1613:1: rule__CreateModel__Group__4__Impl : ( 'inResource' ) ;
    public final void rule__CreateModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1617:1: ( ( 'inResource' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1618:1: ( 'inResource' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1618:1: ( 'inResource' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1619:1: 'inResource'
            {
             before(grammarAccess.getCreateModelAccess().getInResourceKeyword_4()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__CreateModel__Group__4__Impl3284); 
             after(grammarAccess.getCreateModelAccess().getInResourceKeyword_4()); 

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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1632:1: rule__CreateModel__Group__5 : rule__CreateModel__Group__5__Impl rule__CreateModel__Group__6 ;
    public final void rule__CreateModel__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1636:1: ( rule__CreateModel__Group__5__Impl rule__CreateModel__Group__6 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1637:2: rule__CreateModel__Group__5__Impl rule__CreateModel__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__5__Impl_in_rule__CreateModel__Group__53315);
            rule__CreateModel__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__6_in_rule__CreateModel__Group__53318);
            rule__CreateModel__Group__6();

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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1644:1: rule__CreateModel__Group__5__Impl : ( ( rule__CreateModel__ModelNameAssignment_5 ) ) ;
    public final void rule__CreateModel__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1648:1: ( ( ( rule__CreateModel__ModelNameAssignment_5 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1649:1: ( ( rule__CreateModel__ModelNameAssignment_5 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1649:1: ( ( rule__CreateModel__ModelNameAssignment_5 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1650:1: ( rule__CreateModel__ModelNameAssignment_5 )
            {
             before(grammarAccess.getCreateModelAccess().getModelNameAssignment_5()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1651:1: ( rule__CreateModel__ModelNameAssignment_5 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1651:2: rule__CreateModel__ModelNameAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__ModelNameAssignment_5_in_rule__CreateModel__Group__5__Impl3345);
            rule__CreateModel__ModelNameAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getCreateModelAccess().getModelNameAssignment_5()); 

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


    // $ANTLR start "rule__CreateModel__Group__6"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1661:1: rule__CreateModel__Group__6 : rule__CreateModel__Group__6__Impl rule__CreateModel__Group__7 ;
    public final void rule__CreateModel__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1665:1: ( rule__CreateModel__Group__6__Impl rule__CreateModel__Group__7 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1666:2: rule__CreateModel__Group__6__Impl rule__CreateModel__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__6__Impl_in_rule__CreateModel__Group__63375);
            rule__CreateModel__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__7_in_rule__CreateModel__Group__63378);
            rule__CreateModel__Group__7();

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
    // $ANTLR end "rule__CreateModel__Group__6"


    // $ANTLR start "rule__CreateModel__Group__6__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1673:1: rule__CreateModel__Group__6__Impl : ( 'at' ) ;
    public final void rule__CreateModel__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1677:1: ( ( 'at' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1678:1: ( 'at' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1678:1: ( 'at' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1679:1: 'at'
            {
             before(grammarAccess.getCreateModelAccess().getAtKeyword_6()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__CreateModel__Group__6__Impl3406); 
             after(grammarAccess.getCreateModelAccess().getAtKeyword_6()); 

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
    // $ANTLR end "rule__CreateModel__Group__6__Impl"


    // $ANTLR start "rule__CreateModel__Group__7"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1692:1: rule__CreateModel__Group__7 : rule__CreateModel__Group__7__Impl ;
    public final void rule__CreateModel__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1696:1: ( rule__CreateModel__Group__7__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1697:2: rule__CreateModel__Group__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__Group__7__Impl_in_rule__CreateModel__Group__73437);
            rule__CreateModel__Group__7__Impl();

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
    // $ANTLR end "rule__CreateModel__Group__7"


    // $ANTLR start "rule__CreateModel__Group__7__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1703:1: rule__CreateModel__Group__7__Impl : ( ( rule__CreateModel__PathAssignment_7 ) ) ;
    public final void rule__CreateModel__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1707:1: ( ( ( rule__CreateModel__PathAssignment_7 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1708:1: ( ( rule__CreateModel__PathAssignment_7 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1708:1: ( ( rule__CreateModel__PathAssignment_7 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1709:1: ( rule__CreateModel__PathAssignment_7 )
            {
             before(grammarAccess.getCreateModelAccess().getPathAssignment_7()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1710:1: ( rule__CreateModel__PathAssignment_7 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1710:2: rule__CreateModel__PathAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_rule__CreateModel__PathAssignment_7_in_rule__CreateModel__Group__7__Impl3464);
            rule__CreateModel__PathAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getCreateModelAccess().getPathAssignment_7()); 

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
    // $ANTLR end "rule__CreateModel__Group__7__Impl"


    // $ANTLR start "rule__Save__Group__0"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1736:1: rule__Save__Group__0 : rule__Save__Group__0__Impl rule__Save__Group__1 ;
    public final void rule__Save__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1740:1: ( rule__Save__Group__0__Impl rule__Save__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1741:2: rule__Save__Group__0__Impl rule__Save__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Save__Group__0__Impl_in_rule__Save__Group__03510);
            rule__Save__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Save__Group__1_in_rule__Save__Group__03513);
            rule__Save__Group__1();

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
    // $ANTLR end "rule__Save__Group__0"


    // $ANTLR start "rule__Save__Group__0__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1748:1: rule__Save__Group__0__Impl : ( 'save' ) ;
    public final void rule__Save__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1752:1: ( ( 'save' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1753:1: ( 'save' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1753:1: ( 'save' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1754:1: 'save'
            {
             before(grammarAccess.getSaveAccess().getSaveKeyword_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Save__Group__0__Impl3541); 
             after(grammarAccess.getSaveAccess().getSaveKeyword_0()); 

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
    // $ANTLR end "rule__Save__Group__0__Impl"


    // $ANTLR start "rule__Save__Group__1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1767:1: rule__Save__Group__1 : rule__Save__Group__1__Impl ;
    public final void rule__Save__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1771:1: ( rule__Save__Group__1__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1772:2: rule__Save__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Save__Group__1__Impl_in_rule__Save__Group__13572);
            rule__Save__Group__1__Impl();

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
    // $ANTLR end "rule__Save__Group__1"


    // $ANTLR start "rule__Save__Group__1__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1778:1: rule__Save__Group__1__Impl : ( () ) ;
    public final void rule__Save__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1782:1: ( ( () ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1783:1: ( () )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1783:1: ( () )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1784:1: ()
            {
             before(grammarAccess.getSaveAccess().getSaveAction_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1785:1: ()
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1787:1: 
            {
            }

             after(grammarAccess.getSaveAccess().getSaveAction_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group__1__Impl"


    // $ANTLR start "rule__Check__Group__0"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1801:1: rule__Check__Group__0 : rule__Check__Group__0__Impl rule__Check__Group__1 ;
    public final void rule__Check__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1805:1: ( rule__Check__Group__0__Impl rule__Check__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1806:2: rule__Check__Group__0__Impl rule__Check__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Check__Group__0__Impl_in_rule__Check__Group__03634);
            rule__Check__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Check__Group__1_in_rule__Check__Group__03637);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1813:1: rule__Check__Group__0__Impl : ( 'check!' ) ;
    public final void rule__Check__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1817:1: ( ( 'check!' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1818:1: ( 'check!' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1818:1: ( 'check!' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1819:1: 'check!'
            {
             before(grammarAccess.getCheckAccess().getCheckKeyword_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Check__Group__0__Impl3665); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1832:1: rule__Check__Group__1 : rule__Check__Group__1__Impl ;
    public final void rule__Check__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1836:1: ( rule__Check__Group__1__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1837:2: rule__Check__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Check__Group__1__Impl_in_rule__Check__Group__13696);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1843:1: rule__Check__Group__1__Impl : ( () ) ;
    public final void rule__Check__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1847:1: ( ( () ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1848:1: ( () )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1848:1: ( () )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1849:1: ()
            {
             before(grammarAccess.getCheckAccess().getCheckAction_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1850:1: ()
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1852:1: 
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


    // $ANTLR start "rule__Add__Group__0"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1866:1: rule__Add__Group__0 : rule__Add__Group__0__Impl rule__Add__Group__1 ;
    public final void rule__Add__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1870:1: ( rule__Add__Group__0__Impl rule__Add__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1871:2: rule__Add__Group__0__Impl rule__Add__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Add__Group__0__Impl_in_rule__Add__Group__03758);
            rule__Add__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Add__Group__1_in_rule__Add__Group__03761);
            rule__Add__Group__1();

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
    // $ANTLR end "rule__Add__Group__0"


    // $ANTLR start "rule__Add__Group__0__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1878:1: rule__Add__Group__0__Impl : ( 'createObject' ) ;
    public final void rule__Add__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1882:1: ( ( 'createObject' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1883:1: ( 'createObject' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1883:1: ( 'createObject' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1884:1: 'createObject'
            {
             before(grammarAccess.getAddAccess().getCreateObjectKeyword_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Add__Group__0__Impl3789); 
             after(grammarAccess.getAddAccess().getCreateObjectKeyword_0()); 

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
    // $ANTLR end "rule__Add__Group__0__Impl"


    // $ANTLR start "rule__Add__Group__1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1897:1: rule__Add__Group__1 : rule__Add__Group__1__Impl rule__Add__Group__2 ;
    public final void rule__Add__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1901:1: ( rule__Add__Group__1__Impl rule__Add__Group__2 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1902:2: rule__Add__Group__1__Impl rule__Add__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Add__Group__1__Impl_in_rule__Add__Group__13820);
            rule__Add__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Add__Group__2_in_rule__Add__Group__13823);
            rule__Add__Group__2();

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
    // $ANTLR end "rule__Add__Group__1"


    // $ANTLR start "rule__Add__Group__1__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1909:1: rule__Add__Group__1__Impl : ( ( rule__Add__ReferenceNameAssignment_1 ) ) ;
    public final void rule__Add__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1913:1: ( ( ( rule__Add__ReferenceNameAssignment_1 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1914:1: ( ( rule__Add__ReferenceNameAssignment_1 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1914:1: ( ( rule__Add__ReferenceNameAssignment_1 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1915:1: ( rule__Add__ReferenceNameAssignment_1 )
            {
             before(grammarAccess.getAddAccess().getReferenceNameAssignment_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1916:1: ( rule__Add__ReferenceNameAssignment_1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1916:2: rule__Add__ReferenceNameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Add__ReferenceNameAssignment_1_in_rule__Add__Group__1__Impl3850);
            rule__Add__ReferenceNameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAddAccess().getReferenceNameAssignment_1()); 

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
    // $ANTLR end "rule__Add__Group__1__Impl"


    // $ANTLR start "rule__Add__Group__2"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1926:1: rule__Add__Group__2 : rule__Add__Group__2__Impl rule__Add__Group__3 ;
    public final void rule__Add__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1930:1: ( rule__Add__Group__2__Impl rule__Add__Group__3 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1931:2: rule__Add__Group__2__Impl rule__Add__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Add__Group__2__Impl_in_rule__Add__Group__23880);
            rule__Add__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Add__Group__3_in_rule__Add__Group__23883);
            rule__Add__Group__3();

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
    // $ANTLR end "rule__Add__Group__2"


    // $ANTLR start "rule__Add__Group__2__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1938:1: rule__Add__Group__2__Impl : ( ':' ) ;
    public final void rule__Add__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1942:1: ( ( ':' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1943:1: ( ':' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1943:1: ( ':' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1944:1: ':'
            {
             before(grammarAccess.getAddAccess().getColonKeyword_2()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Add__Group__2__Impl3911); 
             after(grammarAccess.getAddAccess().getColonKeyword_2()); 

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
    // $ANTLR end "rule__Add__Group__2__Impl"


    // $ANTLR start "rule__Add__Group__3"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1957:1: rule__Add__Group__3 : rule__Add__Group__3__Impl rule__Add__Group__4 ;
    public final void rule__Add__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1961:1: ( rule__Add__Group__3__Impl rule__Add__Group__4 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1962:2: rule__Add__Group__3__Impl rule__Add__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Add__Group__3__Impl_in_rule__Add__Group__33942);
            rule__Add__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Add__Group__4_in_rule__Add__Group__33945);
            rule__Add__Group__4();

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
    // $ANTLR end "rule__Add__Group__3"


    // $ANTLR start "rule__Add__Group__3__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1969:1: rule__Add__Group__3__Impl : ( ( rule__Add__TypeURIAssignment_3 ) ) ;
    public final void rule__Add__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1973:1: ( ( ( rule__Add__TypeURIAssignment_3 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1974:1: ( ( rule__Add__TypeURIAssignment_3 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1974:1: ( ( rule__Add__TypeURIAssignment_3 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1975:1: ( rule__Add__TypeURIAssignment_3 )
            {
             before(grammarAccess.getAddAccess().getTypeURIAssignment_3()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1976:1: ( rule__Add__TypeURIAssignment_3 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1976:2: rule__Add__TypeURIAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Add__TypeURIAssignment_3_in_rule__Add__Group__3__Impl3972);
            rule__Add__TypeURIAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAddAccess().getTypeURIAssignment_3()); 

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
    // $ANTLR end "rule__Add__Group__3__Impl"


    // $ANTLR start "rule__Add__Group__4"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1986:1: rule__Add__Group__4 : rule__Add__Group__4__Impl rule__Add__Group__5 ;
    public final void rule__Add__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1990:1: ( rule__Add__Group__4__Impl rule__Add__Group__5 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1991:2: rule__Add__Group__4__Impl rule__Add__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Add__Group__4__Impl_in_rule__Add__Group__44002);
            rule__Add__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Add__Group__5_in_rule__Add__Group__44005);
            rule__Add__Group__5();

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
    // $ANTLR end "rule__Add__Group__4"


    // $ANTLR start "rule__Add__Group__4__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1998:1: rule__Add__Group__4__Impl : ( 'inElement' ) ;
    public final void rule__Add__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2002:1: ( ( 'inElement' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2003:1: ( 'inElement' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2003:1: ( 'inElement' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2004:1: 'inElement'
            {
             before(grammarAccess.getAddAccess().getInElementKeyword_4()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__Add__Group__4__Impl4033); 
             after(grammarAccess.getAddAccess().getInElementKeyword_4()); 

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
    // $ANTLR end "rule__Add__Group__4__Impl"


    // $ANTLR start "rule__Add__Group__5"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2017:1: rule__Add__Group__5 : rule__Add__Group__5__Impl rule__Add__Group__6 ;
    public final void rule__Add__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2021:1: ( rule__Add__Group__5__Impl rule__Add__Group__6 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2022:2: rule__Add__Group__5__Impl rule__Add__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__Add__Group__5__Impl_in_rule__Add__Group__54064);
            rule__Add__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Add__Group__6_in_rule__Add__Group__54067);
            rule__Add__Group__6();

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
    // $ANTLR end "rule__Add__Group__5"


    // $ANTLR start "rule__Add__Group__5__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2029:1: rule__Add__Group__5__Impl : ( ( rule__Add__ReferenceableObjectAssignment_5 ) ) ;
    public final void rule__Add__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2033:1: ( ( ( rule__Add__ReferenceableObjectAssignment_5 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2034:1: ( ( rule__Add__ReferenceableObjectAssignment_5 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2034:1: ( ( rule__Add__ReferenceableObjectAssignment_5 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2035:1: ( rule__Add__ReferenceableObjectAssignment_5 )
            {
             before(grammarAccess.getAddAccess().getReferenceableObjectAssignment_5()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2036:1: ( rule__Add__ReferenceableObjectAssignment_5 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2036:2: rule__Add__ReferenceableObjectAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Add__ReferenceableObjectAssignment_5_in_rule__Add__Group__5__Impl4094);
            rule__Add__ReferenceableObjectAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getAddAccess().getReferenceableObjectAssignment_5()); 

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
    // $ANTLR end "rule__Add__Group__5__Impl"


    // $ANTLR start "rule__Add__Group__6"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2046:1: rule__Add__Group__6 : rule__Add__Group__6__Impl rule__Add__Group__7 ;
    public final void rule__Add__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2050:1: ( rule__Add__Group__6__Impl rule__Add__Group__7 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2051:2: rule__Add__Group__6__Impl rule__Add__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__Add__Group__6__Impl_in_rule__Add__Group__64124);
            rule__Add__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Add__Group__7_in_rule__Add__Group__64127);
            rule__Add__Group__7();

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
    // $ANTLR end "rule__Add__Group__6"


    // $ANTLR start "rule__Add__Group__6__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2058:1: rule__Add__Group__6__Impl : ( 'inFeature' ) ;
    public final void rule__Add__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2062:1: ( ( 'inFeature' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2063:1: ( 'inFeature' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2063:1: ( 'inFeature' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2064:1: 'inFeature'
            {
             before(grammarAccess.getAddAccess().getInFeatureKeyword_6()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Add__Group__6__Impl4155); 
             after(grammarAccess.getAddAccess().getInFeatureKeyword_6()); 

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
    // $ANTLR end "rule__Add__Group__6__Impl"


    // $ANTLR start "rule__Add__Group__7"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2077:1: rule__Add__Group__7 : rule__Add__Group__7__Impl ;
    public final void rule__Add__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2081:1: ( rule__Add__Group__7__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2082:2: rule__Add__Group__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Add__Group__7__Impl_in_rule__Add__Group__74186);
            rule__Add__Group__7__Impl();

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
    // $ANTLR end "rule__Add__Group__7"


    // $ANTLR start "rule__Add__Group__7__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2088:1: rule__Add__Group__7__Impl : ( ( rule__Add__EContainingFeatureURIAssignment_7 ) ) ;
    public final void rule__Add__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2092:1: ( ( ( rule__Add__EContainingFeatureURIAssignment_7 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2093:1: ( ( rule__Add__EContainingFeatureURIAssignment_7 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2093:1: ( ( rule__Add__EContainingFeatureURIAssignment_7 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2094:1: ( rule__Add__EContainingFeatureURIAssignment_7 )
            {
             before(grammarAccess.getAddAccess().getEContainingFeatureURIAssignment_7()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2095:1: ( rule__Add__EContainingFeatureURIAssignment_7 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2095:2: rule__Add__EContainingFeatureURIAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_rule__Add__EContainingFeatureURIAssignment_7_in_rule__Add__Group__7__Impl4213);
            rule__Add__EContainingFeatureURIAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getAddAccess().getEContainingFeatureURIAssignment_7()); 

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
    // $ANTLR end "rule__Add__Group__7__Impl"


    // $ANTLR start "rule__SetAttribute__Group__0"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2121:1: rule__SetAttribute__Group__0 : rule__SetAttribute__Group__0__Impl rule__SetAttribute__Group__1 ;
    public final void rule__SetAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2125:1: ( rule__SetAttribute__Group__0__Impl rule__SetAttribute__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2126:2: rule__SetAttribute__Group__0__Impl rule__SetAttribute__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group__0__Impl_in_rule__SetAttribute__Group__04259);
            rule__SetAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group__1_in_rule__SetAttribute__Group__04262);
            rule__SetAttribute__Group__1();

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
    // $ANTLR end "rule__SetAttribute__Group__0"


    // $ANTLR start "rule__SetAttribute__Group__0__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2133:1: rule__SetAttribute__Group__0__Impl : ( 'set' ) ;
    public final void rule__SetAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2137:1: ( ( 'set' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2138:1: ( 'set' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2138:1: ( 'set' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2139:1: 'set'
            {
             before(grammarAccess.getSetAttributeAccess().getSetKeyword_0()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__SetAttribute__Group__0__Impl4290); 
             after(grammarAccess.getSetAttributeAccess().getSetKeyword_0()); 

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
    // $ANTLR end "rule__SetAttribute__Group__0__Impl"


    // $ANTLR start "rule__SetAttribute__Group__1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2152:1: rule__SetAttribute__Group__1 : rule__SetAttribute__Group__1__Impl rule__SetAttribute__Group__2 ;
    public final void rule__SetAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2156:1: ( rule__SetAttribute__Group__1__Impl rule__SetAttribute__Group__2 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2157:2: rule__SetAttribute__Group__1__Impl rule__SetAttribute__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group__1__Impl_in_rule__SetAttribute__Group__14321);
            rule__SetAttribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group__2_in_rule__SetAttribute__Group__14324);
            rule__SetAttribute__Group__2();

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
    // $ANTLR end "rule__SetAttribute__Group__1"


    // $ANTLR start "rule__SetAttribute__Group__1__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2164:1: rule__SetAttribute__Group__1__Impl : ( ( rule__SetAttribute__ReferenceableObjectAssignment_1 ) ) ;
    public final void rule__SetAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2168:1: ( ( ( rule__SetAttribute__ReferenceableObjectAssignment_1 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2169:1: ( ( rule__SetAttribute__ReferenceableObjectAssignment_1 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2169:1: ( ( rule__SetAttribute__ReferenceableObjectAssignment_1 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2170:1: ( rule__SetAttribute__ReferenceableObjectAssignment_1 )
            {
             before(grammarAccess.getSetAttributeAccess().getReferenceableObjectAssignment_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2171:1: ( rule__SetAttribute__ReferenceableObjectAssignment_1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2171:2: rule__SetAttribute__ReferenceableObjectAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__ReferenceableObjectAssignment_1_in_rule__SetAttribute__Group__1__Impl4351);
            rule__SetAttribute__ReferenceableObjectAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSetAttributeAccess().getReferenceableObjectAssignment_1()); 

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
    // $ANTLR end "rule__SetAttribute__Group__1__Impl"


    // $ANTLR start "rule__SetAttribute__Group__2"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2181:1: rule__SetAttribute__Group__2 : rule__SetAttribute__Group__2__Impl rule__SetAttribute__Group__3 ;
    public final void rule__SetAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2185:1: ( rule__SetAttribute__Group__2__Impl rule__SetAttribute__Group__3 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2186:2: rule__SetAttribute__Group__2__Impl rule__SetAttribute__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group__2__Impl_in_rule__SetAttribute__Group__24381);
            rule__SetAttribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group__3_in_rule__SetAttribute__Group__24384);
            rule__SetAttribute__Group__3();

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
    // $ANTLR end "rule__SetAttribute__Group__2"


    // $ANTLR start "rule__SetAttribute__Group__2__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2193:1: rule__SetAttribute__Group__2__Impl : ( 'values' ) ;
    public final void rule__SetAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2197:1: ( ( 'values' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2198:1: ( 'values' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2198:1: ( 'values' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2199:1: 'values'
            {
             before(grammarAccess.getSetAttributeAccess().getValuesKeyword_2()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__SetAttribute__Group__2__Impl4412); 
             after(grammarAccess.getSetAttributeAccess().getValuesKeyword_2()); 

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
    // $ANTLR end "rule__SetAttribute__Group__2__Impl"


    // $ANTLR start "rule__SetAttribute__Group__3"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2212:1: rule__SetAttribute__Group__3 : rule__SetAttribute__Group__3__Impl rule__SetAttribute__Group__4 ;
    public final void rule__SetAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2216:1: ( rule__SetAttribute__Group__3__Impl rule__SetAttribute__Group__4 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2217:2: rule__SetAttribute__Group__3__Impl rule__SetAttribute__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group__3__Impl_in_rule__SetAttribute__Group__34443);
            rule__SetAttribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group__4_in_rule__SetAttribute__Group__34446);
            rule__SetAttribute__Group__4();

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
    // $ANTLR end "rule__SetAttribute__Group__3"


    // $ANTLR start "rule__SetAttribute__Group__3__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2224:1: rule__SetAttribute__Group__3__Impl : ( ( rule__SetAttribute__ValuesAssignment_3 ) ) ;
    public final void rule__SetAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2228:1: ( ( ( rule__SetAttribute__ValuesAssignment_3 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2229:1: ( ( rule__SetAttribute__ValuesAssignment_3 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2229:1: ( ( rule__SetAttribute__ValuesAssignment_3 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2230:1: ( rule__SetAttribute__ValuesAssignment_3 )
            {
             before(grammarAccess.getSetAttributeAccess().getValuesAssignment_3()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2231:1: ( rule__SetAttribute__ValuesAssignment_3 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2231:2: rule__SetAttribute__ValuesAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__ValuesAssignment_3_in_rule__SetAttribute__Group__3__Impl4473);
            rule__SetAttribute__ValuesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSetAttributeAccess().getValuesAssignment_3()); 

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
    // $ANTLR end "rule__SetAttribute__Group__3__Impl"


    // $ANTLR start "rule__SetAttribute__Group__4"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2241:1: rule__SetAttribute__Group__4 : rule__SetAttribute__Group__4__Impl rule__SetAttribute__Group__5 ;
    public final void rule__SetAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2245:1: ( rule__SetAttribute__Group__4__Impl rule__SetAttribute__Group__5 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2246:2: rule__SetAttribute__Group__4__Impl rule__SetAttribute__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group__4__Impl_in_rule__SetAttribute__Group__44503);
            rule__SetAttribute__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group__5_in_rule__SetAttribute__Group__44506);
            rule__SetAttribute__Group__5();

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
    // $ANTLR end "rule__SetAttribute__Group__4"


    // $ANTLR start "rule__SetAttribute__Group__4__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2253:1: rule__SetAttribute__Group__4__Impl : ( ( rule__SetAttribute__Group_4__0 )* ) ;
    public final void rule__SetAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2257:1: ( ( ( rule__SetAttribute__Group_4__0 )* ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2258:1: ( ( rule__SetAttribute__Group_4__0 )* )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2258:1: ( ( rule__SetAttribute__Group_4__0 )* )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2259:1: ( rule__SetAttribute__Group_4__0 )*
            {
             before(grammarAccess.getSetAttributeAccess().getGroup_4()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2260:1: ( rule__SetAttribute__Group_4__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==29) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2260:2: rule__SetAttribute__Group_4__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group_4__0_in_rule__SetAttribute__Group__4__Impl4533);
            	    rule__SetAttribute__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getSetAttributeAccess().getGroup_4()); 

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
    // $ANTLR end "rule__SetAttribute__Group__4__Impl"


    // $ANTLR start "rule__SetAttribute__Group__5"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2270:1: rule__SetAttribute__Group__5 : rule__SetAttribute__Group__5__Impl rule__SetAttribute__Group__6 ;
    public final void rule__SetAttribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2274:1: ( rule__SetAttribute__Group__5__Impl rule__SetAttribute__Group__6 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2275:2: rule__SetAttribute__Group__5__Impl rule__SetAttribute__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group__5__Impl_in_rule__SetAttribute__Group__54564);
            rule__SetAttribute__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group__6_in_rule__SetAttribute__Group__54567);
            rule__SetAttribute__Group__6();

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
    // $ANTLR end "rule__SetAttribute__Group__5"


    // $ANTLR start "rule__SetAttribute__Group__5__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2282:1: rule__SetAttribute__Group__5__Impl : ( 'inFeature' ) ;
    public final void rule__SetAttribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2286:1: ( ( 'inFeature' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2287:1: ( 'inFeature' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2287:1: ( 'inFeature' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2288:1: 'inFeature'
            {
             before(grammarAccess.getSetAttributeAccess().getInFeatureKeyword_5()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__SetAttribute__Group__5__Impl4595); 
             after(grammarAccess.getSetAttributeAccess().getInFeatureKeyword_5()); 

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
    // $ANTLR end "rule__SetAttribute__Group__5__Impl"


    // $ANTLR start "rule__SetAttribute__Group__6"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2301:1: rule__SetAttribute__Group__6 : rule__SetAttribute__Group__6__Impl rule__SetAttribute__Group__7 ;
    public final void rule__SetAttribute__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2305:1: ( rule__SetAttribute__Group__6__Impl rule__SetAttribute__Group__7 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2306:2: rule__SetAttribute__Group__6__Impl rule__SetAttribute__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group__6__Impl_in_rule__SetAttribute__Group__64626);
            rule__SetAttribute__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group__7_in_rule__SetAttribute__Group__64629);
            rule__SetAttribute__Group__7();

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
    // $ANTLR end "rule__SetAttribute__Group__6"


    // $ANTLR start "rule__SetAttribute__Group__6__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2313:1: rule__SetAttribute__Group__6__Impl : ( ( rule__SetAttribute__EContainingFeatureURIAssignment_6 ) ) ;
    public final void rule__SetAttribute__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2317:1: ( ( ( rule__SetAttribute__EContainingFeatureURIAssignment_6 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2318:1: ( ( rule__SetAttribute__EContainingFeatureURIAssignment_6 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2318:1: ( ( rule__SetAttribute__EContainingFeatureURIAssignment_6 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2319:1: ( rule__SetAttribute__EContainingFeatureURIAssignment_6 )
            {
             before(grammarAccess.getSetAttributeAccess().getEContainingFeatureURIAssignment_6()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2320:1: ( rule__SetAttribute__EContainingFeatureURIAssignment_6 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2320:2: rule__SetAttribute__EContainingFeatureURIAssignment_6
            {
            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__EContainingFeatureURIAssignment_6_in_rule__SetAttribute__Group__6__Impl4656);
            rule__SetAttribute__EContainingFeatureURIAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getSetAttributeAccess().getEContainingFeatureURIAssignment_6()); 

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
    // $ANTLR end "rule__SetAttribute__Group__6__Impl"


    // $ANTLR start "rule__SetAttribute__Group__7"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2330:1: rule__SetAttribute__Group__7 : rule__SetAttribute__Group__7__Impl ;
    public final void rule__SetAttribute__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2334:1: ( rule__SetAttribute__Group__7__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2335:2: rule__SetAttribute__Group__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group__7__Impl_in_rule__SetAttribute__Group__74686);
            rule__SetAttribute__Group__7__Impl();

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
    // $ANTLR end "rule__SetAttribute__Group__7"


    // $ANTLR start "rule__SetAttribute__Group__7__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2341:1: rule__SetAttribute__Group__7__Impl : ( ( rule__SetAttribute__Group_7__0 )? ) ;
    public final void rule__SetAttribute__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2345:1: ( ( ( rule__SetAttribute__Group_7__0 )? ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2346:1: ( ( rule__SetAttribute__Group_7__0 )? )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2346:1: ( ( rule__SetAttribute__Group_7__0 )? )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2347:1: ( rule__SetAttribute__Group_7__0 )?
            {
             before(grammarAccess.getSetAttributeAccess().getGroup_7()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2348:1: ( rule__SetAttribute__Group_7__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==30) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2348:2: rule__SetAttribute__Group_7__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group_7__0_in_rule__SetAttribute__Group__7__Impl4713);
                    rule__SetAttribute__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSetAttributeAccess().getGroup_7()); 

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
    // $ANTLR end "rule__SetAttribute__Group__7__Impl"


    // $ANTLR start "rule__SetAttribute__Group_4__0"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2374:1: rule__SetAttribute__Group_4__0 : rule__SetAttribute__Group_4__0__Impl rule__SetAttribute__Group_4__1 ;
    public final void rule__SetAttribute__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2378:1: ( rule__SetAttribute__Group_4__0__Impl rule__SetAttribute__Group_4__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2379:2: rule__SetAttribute__Group_4__0__Impl rule__SetAttribute__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group_4__0__Impl_in_rule__SetAttribute__Group_4__04760);
            rule__SetAttribute__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group_4__1_in_rule__SetAttribute__Group_4__04763);
            rule__SetAttribute__Group_4__1();

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
    // $ANTLR end "rule__SetAttribute__Group_4__0"


    // $ANTLR start "rule__SetAttribute__Group_4__0__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2386:1: rule__SetAttribute__Group_4__0__Impl : ( ',' ) ;
    public final void rule__SetAttribute__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2390:1: ( ( ',' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2391:1: ( ',' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2391:1: ( ',' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2392:1: ','
            {
             before(grammarAccess.getSetAttributeAccess().getCommaKeyword_4_0()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__SetAttribute__Group_4__0__Impl4791); 
             after(grammarAccess.getSetAttributeAccess().getCommaKeyword_4_0()); 

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
    // $ANTLR end "rule__SetAttribute__Group_4__0__Impl"


    // $ANTLR start "rule__SetAttribute__Group_4__1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2405:1: rule__SetAttribute__Group_4__1 : rule__SetAttribute__Group_4__1__Impl ;
    public final void rule__SetAttribute__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2409:1: ( rule__SetAttribute__Group_4__1__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2410:2: rule__SetAttribute__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group_4__1__Impl_in_rule__SetAttribute__Group_4__14822);
            rule__SetAttribute__Group_4__1__Impl();

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
    // $ANTLR end "rule__SetAttribute__Group_4__1"


    // $ANTLR start "rule__SetAttribute__Group_4__1__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2416:1: rule__SetAttribute__Group_4__1__Impl : ( ( rule__SetAttribute__ValuesAssignment_4_1 ) ) ;
    public final void rule__SetAttribute__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2420:1: ( ( ( rule__SetAttribute__ValuesAssignment_4_1 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2421:1: ( ( rule__SetAttribute__ValuesAssignment_4_1 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2421:1: ( ( rule__SetAttribute__ValuesAssignment_4_1 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2422:1: ( rule__SetAttribute__ValuesAssignment_4_1 )
            {
             before(grammarAccess.getSetAttributeAccess().getValuesAssignment_4_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2423:1: ( rule__SetAttribute__ValuesAssignment_4_1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2423:2: rule__SetAttribute__ValuesAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__ValuesAssignment_4_1_in_rule__SetAttribute__Group_4__1__Impl4849);
            rule__SetAttribute__ValuesAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getSetAttributeAccess().getValuesAssignment_4_1()); 

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
    // $ANTLR end "rule__SetAttribute__Group_4__1__Impl"


    // $ANTLR start "rule__SetAttribute__Group_7__0"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2437:1: rule__SetAttribute__Group_7__0 : rule__SetAttribute__Group_7__0__Impl rule__SetAttribute__Group_7__1 ;
    public final void rule__SetAttribute__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2441:1: ( rule__SetAttribute__Group_7__0__Impl rule__SetAttribute__Group_7__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2442:2: rule__SetAttribute__Group_7__0__Impl rule__SetAttribute__Group_7__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group_7__0__Impl_in_rule__SetAttribute__Group_7__04883);
            rule__SetAttribute__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group_7__1_in_rule__SetAttribute__Group_7__04886);
            rule__SetAttribute__Group_7__1();

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
    // $ANTLR end "rule__SetAttribute__Group_7__0"


    // $ANTLR start "rule__SetAttribute__Group_7__0__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2449:1: rule__SetAttribute__Group_7__0__Impl : ( 'usingWidget' ) ;
    public final void rule__SetAttribute__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2453:1: ( ( 'usingWidget' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2454:1: ( 'usingWidget' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2454:1: ( 'usingWidget' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2455:1: 'usingWidget'
            {
             before(grammarAccess.getSetAttributeAccess().getUsingWidgetKeyword_7_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__SetAttribute__Group_7__0__Impl4914); 
             after(grammarAccess.getSetAttributeAccess().getUsingWidgetKeyword_7_0()); 

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
    // $ANTLR end "rule__SetAttribute__Group_7__0__Impl"


    // $ANTLR start "rule__SetAttribute__Group_7__1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2468:1: rule__SetAttribute__Group_7__1 : rule__SetAttribute__Group_7__1__Impl ;
    public final void rule__SetAttribute__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2472:1: ( rule__SetAttribute__Group_7__1__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2473:2: rule__SetAttribute__Group_7__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__Group_7__1__Impl_in_rule__SetAttribute__Group_7__14945);
            rule__SetAttribute__Group_7__1__Impl();

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
    // $ANTLR end "rule__SetAttribute__Group_7__1"


    // $ANTLR start "rule__SetAttribute__Group_7__1__Impl"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2479:1: rule__SetAttribute__Group_7__1__Impl : ( ( rule__SetAttribute__PropertiesEditionElementURIAssignment_7_1 ) ) ;
    public final void rule__SetAttribute__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2483:1: ( ( ( rule__SetAttribute__PropertiesEditionElementURIAssignment_7_1 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2484:1: ( ( rule__SetAttribute__PropertiesEditionElementURIAssignment_7_1 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2484:1: ( ( rule__SetAttribute__PropertiesEditionElementURIAssignment_7_1 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2485:1: ( rule__SetAttribute__PropertiesEditionElementURIAssignment_7_1 )
            {
             before(grammarAccess.getSetAttributeAccess().getPropertiesEditionElementURIAssignment_7_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2486:1: ( rule__SetAttribute__PropertiesEditionElementURIAssignment_7_1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2486:2: rule__SetAttribute__PropertiesEditionElementURIAssignment_7_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SetAttribute__PropertiesEditionElementURIAssignment_7_1_in_rule__SetAttribute__Group_7__1__Impl4972);
            rule__SetAttribute__PropertiesEditionElementURIAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getSetAttributeAccess().getPropertiesEditionElementURIAssignment_7_1()); 

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
    // $ANTLR end "rule__SetAttribute__Group_7__1__Impl"


    // $ANTLR start "rule__Scenario__NameAssignment_1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2501:1: rule__Scenario__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Scenario__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2505:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2506:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2506:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2507:1: ruleEString
            {
             before(grammarAccess.getScenarioAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Scenario__NameAssignment_15011);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2516:1: rule__Scenario__ProcessingsAssignment_3 : ( ruleProcessings ) ;
    public final void rule__Scenario__ProcessingsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2520:1: ( ( ruleProcessings ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2521:1: ( ruleProcessings )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2521:1: ( ruleProcessings )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2522:1: ruleProcessings
            {
             before(grammarAccess.getScenarioAccess().getProcessingsProcessingsParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleProcessings_in_rule__Scenario__ProcessingsAssignment_35042);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2531:1: rule__PropertiesView__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__PropertiesView__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2535:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2536:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2536:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2537:1: ruleEString
            {
             before(grammarAccess.getPropertiesViewAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__PropertiesView__NameAssignment_15073);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2546:1: rule__PropertiesView__ProcessingsAssignment_3 : ( ruleSubProcessings ) ;
    public final void rule__PropertiesView__ProcessingsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2550:1: ( ( ruleSubProcessings ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2551:1: ( ruleSubProcessings )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2551:1: ( ruleSubProcessings )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2552:1: ruleSubProcessings
            {
             before(grammarAccess.getPropertiesViewAccess().getProcessingsSubProcessingsParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubProcessings_in_rule__PropertiesView__ProcessingsAssignment_35104);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2561:1: rule__Wizard__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Wizard__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2565:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2566:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2566:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2567:1: ruleEString
            {
             before(grammarAccess.getWizardAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Wizard__NameAssignment_15135);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2576:1: rule__Wizard__ProcessingsAssignment_3 : ( ruleSubProcessings ) ;
    public final void rule__Wizard__ProcessingsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2580:1: ( ( ruleSubProcessings ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2581:1: ( ruleSubProcessings )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2581:1: ( ruleSubProcessings )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2582:1: ruleSubProcessings
            {
             before(grammarAccess.getWizardAccess().getProcessingsSubProcessingsParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubProcessings_in_rule__Wizard__ProcessingsAssignment_35166);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2591:1: rule__Details__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Details__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2595:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2596:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2596:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2597:1: ruleEString
            {
             before(grammarAccess.getDetailsAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Details__NameAssignment_15197);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2606:1: rule__Details__ProcessingsAssignment_3 : ( ruleSubProcessings ) ;
    public final void rule__Details__ProcessingsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2610:1: ( ( ruleSubProcessings ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2611:1: ( ruleSubProcessings )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2611:1: ( ruleSubProcessings )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2612:1: ruleSubProcessings
            {
             before(grammarAccess.getDetailsAccess().getProcessingsSubProcessingsParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubProcessings_in_rule__Details__ProcessingsAssignment_35228);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2621:1: rule__CreateProject__ProjectNameAssignment_1 : ( ruleEString ) ;
    public final void rule__CreateProject__ProjectNameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2625:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2626:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2626:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2627:1: ruleEString
            {
             before(grammarAccess.getCreateProjectAccess().getProjectNameEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__CreateProject__ProjectNameAssignment_15259);
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


    // $ANTLR start "rule__RemoveProject__ProjectNameAssignment_1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2636:1: rule__RemoveProject__ProjectNameAssignment_1 : ( ruleEString ) ;
    public final void rule__RemoveProject__ProjectNameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2640:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2641:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2641:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2642:1: ruleEString
            {
             before(grammarAccess.getRemoveProjectAccess().getProjectNameEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__RemoveProject__ProjectNameAssignment_15290);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getRemoveProjectAccess().getProjectNameEStringParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__RemoveProject__ProjectNameAssignment_1"


    // $ANTLR start "rule__CreateModel__ReferenceNameAssignment_1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2651:1: rule__CreateModel__ReferenceNameAssignment_1 : ( RULE_ID ) ;
    public final void rule__CreateModel__ReferenceNameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2655:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2656:1: ( RULE_ID )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2656:1: ( RULE_ID )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2657:1: RULE_ID
            {
             before(grammarAccess.getCreateModelAccess().getReferenceNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__CreateModel__ReferenceNameAssignment_15321); 
             after(grammarAccess.getCreateModelAccess().getReferenceNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__CreateModel__ReferenceNameAssignment_1"


    // $ANTLR start "rule__CreateModel__RootURIAssignment_3"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2666:1: rule__CreateModel__RootURIAssignment_3 : ( ruleEString ) ;
    public final void rule__CreateModel__RootURIAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2670:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2671:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2671:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2672:1: ruleEString
            {
             before(grammarAccess.getCreateModelAccess().getRootURIEStringParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__CreateModel__RootURIAssignment_35352);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getCreateModelAccess().getRootURIEStringParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__CreateModel__RootURIAssignment_3"


    // $ANTLR start "rule__CreateModel__ModelNameAssignment_5"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2681:1: rule__CreateModel__ModelNameAssignment_5 : ( ruleEString ) ;
    public final void rule__CreateModel__ModelNameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2685:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2686:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2686:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2687:1: ruleEString
            {
             before(grammarAccess.getCreateModelAccess().getModelNameEStringParserRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__CreateModel__ModelNameAssignment_55383);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getCreateModelAccess().getModelNameEStringParserRuleCall_5_0()); 

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
    // $ANTLR end "rule__CreateModel__ModelNameAssignment_5"


    // $ANTLR start "rule__CreateModel__PathAssignment_7"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2696:1: rule__CreateModel__PathAssignment_7 : ( ruleEString ) ;
    public final void rule__CreateModel__PathAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2700:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2701:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2701:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2702:1: ruleEString
            {
             before(grammarAccess.getCreateModelAccess().getPathEStringParserRuleCall_7_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__CreateModel__PathAssignment_75414);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getCreateModelAccess().getPathEStringParserRuleCall_7_0()); 

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
    // $ANTLR end "rule__CreateModel__PathAssignment_7"


    // $ANTLR start "rule__Add__ReferenceNameAssignment_1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2711:1: rule__Add__ReferenceNameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Add__ReferenceNameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2715:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2716:1: ( RULE_ID )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2716:1: ( RULE_ID )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2717:1: RULE_ID
            {
             before(grammarAccess.getAddAccess().getReferenceNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Add__ReferenceNameAssignment_15445); 
             after(grammarAccess.getAddAccess().getReferenceNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Add__ReferenceNameAssignment_1"


    // $ANTLR start "rule__Add__TypeURIAssignment_3"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2726:1: rule__Add__TypeURIAssignment_3 : ( ruleEString ) ;
    public final void rule__Add__TypeURIAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2730:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2731:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2731:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2732:1: ruleEString
            {
             before(grammarAccess.getAddAccess().getTypeURIEStringParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Add__TypeURIAssignment_35476);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAddAccess().getTypeURIEStringParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__Add__TypeURIAssignment_3"


    // $ANTLR start "rule__Add__ReferenceableObjectAssignment_5"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2741:1: rule__Add__ReferenceableObjectAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__Add__ReferenceableObjectAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2745:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2746:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2746:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2747:1: ( RULE_ID )
            {
             before(grammarAccess.getAddAccess().getReferenceableObjectReferenceableObjectCrossReference_5_0()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2748:1: ( RULE_ID )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2749:1: RULE_ID
            {
             before(grammarAccess.getAddAccess().getReferenceableObjectReferenceableObjectIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Add__ReferenceableObjectAssignment_55511); 
             after(grammarAccess.getAddAccess().getReferenceableObjectReferenceableObjectIDTerminalRuleCall_5_0_1()); 

            }

             after(grammarAccess.getAddAccess().getReferenceableObjectReferenceableObjectCrossReference_5_0()); 

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
    // $ANTLR end "rule__Add__ReferenceableObjectAssignment_5"


    // $ANTLR start "rule__Add__EContainingFeatureURIAssignment_7"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2760:1: rule__Add__EContainingFeatureURIAssignment_7 : ( ruleEString ) ;
    public final void rule__Add__EContainingFeatureURIAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2764:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2765:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2765:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2766:1: ruleEString
            {
             before(grammarAccess.getAddAccess().getEContainingFeatureURIEStringParserRuleCall_7_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Add__EContainingFeatureURIAssignment_75546);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAddAccess().getEContainingFeatureURIEStringParserRuleCall_7_0()); 

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
    // $ANTLR end "rule__Add__EContainingFeatureURIAssignment_7"


    // $ANTLR start "rule__SetAttribute__ReferenceableObjectAssignment_1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2775:1: rule__SetAttribute__ReferenceableObjectAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__SetAttribute__ReferenceableObjectAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2779:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2780:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2780:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2781:1: ( RULE_ID )
            {
             before(grammarAccess.getSetAttributeAccess().getReferenceableObjectReferenceableObjectCrossReference_1_0()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2782:1: ( RULE_ID )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2783:1: RULE_ID
            {
             before(grammarAccess.getSetAttributeAccess().getReferenceableObjectReferenceableObjectIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SetAttribute__ReferenceableObjectAssignment_15581); 
             after(grammarAccess.getSetAttributeAccess().getReferenceableObjectReferenceableObjectIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getSetAttributeAccess().getReferenceableObjectReferenceableObjectCrossReference_1_0()); 

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
    // $ANTLR end "rule__SetAttribute__ReferenceableObjectAssignment_1"


    // $ANTLR start "rule__SetAttribute__ValuesAssignment_3"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2794:1: rule__SetAttribute__ValuesAssignment_3 : ( ruleEString ) ;
    public final void rule__SetAttribute__ValuesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2798:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2799:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2799:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2800:1: ruleEString
            {
             before(grammarAccess.getSetAttributeAccess().getValuesEStringParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__SetAttribute__ValuesAssignment_35616);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSetAttributeAccess().getValuesEStringParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__SetAttribute__ValuesAssignment_3"


    // $ANTLR start "rule__SetAttribute__ValuesAssignment_4_1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2809:1: rule__SetAttribute__ValuesAssignment_4_1 : ( ruleEString ) ;
    public final void rule__SetAttribute__ValuesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2813:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2814:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2814:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2815:1: ruleEString
            {
             before(grammarAccess.getSetAttributeAccess().getValuesEStringParserRuleCall_4_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__SetAttribute__ValuesAssignment_4_15647);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSetAttributeAccess().getValuesEStringParserRuleCall_4_1_0()); 

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
    // $ANTLR end "rule__SetAttribute__ValuesAssignment_4_1"


    // $ANTLR start "rule__SetAttribute__EContainingFeatureURIAssignment_6"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2824:1: rule__SetAttribute__EContainingFeatureURIAssignment_6 : ( ruleEString ) ;
    public final void rule__SetAttribute__EContainingFeatureURIAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2828:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2829:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2829:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2830:1: ruleEString
            {
             before(grammarAccess.getSetAttributeAccess().getEContainingFeatureURIEStringParserRuleCall_6_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__SetAttribute__EContainingFeatureURIAssignment_65678);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSetAttributeAccess().getEContainingFeatureURIEStringParserRuleCall_6_0()); 

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
    // $ANTLR end "rule__SetAttribute__EContainingFeatureURIAssignment_6"


    // $ANTLR start "rule__SetAttribute__PropertiesEditionElementURIAssignment_7_1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2839:1: rule__SetAttribute__PropertiesEditionElementURIAssignment_7_1 : ( ruleEString ) ;
    public final void rule__SetAttribute__PropertiesEditionElementURIAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2843:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2844:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2844:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:2845:1: ruleEString
            {
             before(grammarAccess.getSetAttributeAccess().getPropertiesEditionElementURIEStringParserRuleCall_7_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__SetAttribute__PropertiesEditionElementURIAssignment_7_15709);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSetAttributeAccess().getPropertiesEditionElementURIEStringParserRuleCall_7_1_0()); 

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
    // $ANTLR end "rule__SetAttribute__PropertiesEditionElementURIAssignment_7_1"

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
        public static final BitSet FOLLOW_ruleRemoveProject_in_entryRuleRemoveProject601 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRemoveProject608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RemoveProject__Group__0_in_ruleRemoveProject634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateModel_in_entryRuleCreateModel663 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCreateModel670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__0_in_ruleCreateModel696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSave_in_entryRuleSave723 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSave730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Save__Group__0_in_ruleSave756 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEFAction_in_entryRuleEEFAction783 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEEFAction790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EEFAction__Alternatives_in_ruleEEFAction816 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCheck_in_entryRuleCheck843 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCheck850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Check__Group__0_in_ruleCheck876 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAdd_in_entryRuleAdd903 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAdd910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Add__Group__0_in_ruleAdd936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSetAttribute_in_entryRuleSetAttribute963 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSetAttribute970 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group__0_in_ruleSetAttribute996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString1023 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString1030 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EString__Alternatives_in_ruleEString1056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDetails_in_rule__Processings__Alternatives1092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWizard_in_rule__Processings__Alternatives1109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertiesView_in_rule__Processings__Alternatives1126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_rule__Processings__Alternatives1143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWizard_in_rule__SubProcessings__Alternatives1175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDetails_in_rule__SubProcessings__Alternatives1192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertiesView_in_rule__SubProcessings__Alternatives1209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_rule__SubProcessings__Alternatives1226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEclipseAction_in_rule__Action__Alternatives1258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEFAction_in_rule__Action__Alternatives1275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateProject_in_rule__EclipseAction__Alternatives1307 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateModel_in_rule__EclipseAction__Alternatives1324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSave_in_rule__EclipseAction__Alternatives1341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveProject_in_rule__EclipseAction__Alternatives1358 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCheck_in_rule__EEFAction__Alternatives1391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAdd_in_rule__EEFAction__Alternatives1408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSetAttribute_in_rule__EEFAction__Alternatives1425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EString__Alternatives1457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EString__Alternatives1474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario__Group__0__Impl_in_rule__Scenario__Group__01504 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Scenario__Group__1_in_rule__Scenario__Group__01507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Scenario__Group__0__Impl1535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario__Group__1__Impl_in_rule__Scenario__Group__11566 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Scenario__Group__2_in_rule__Scenario__Group__11569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario__NameAssignment_1_in_rule__Scenario__Group__1__Impl1596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario__Group__2__Impl_in_rule__Scenario__Group__21626 = new BitSet(new long[]{0x00000000098FE000L});
        public static final BitSet FOLLOW_rule__Scenario__Group__3_in_rule__Scenario__Group__21629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Scenario__Group__2__Impl1657 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario__Group__3__Impl_in_rule__Scenario__Group__31688 = new BitSet(new long[]{0x00000000098FE000L});
        public static final BitSet FOLLOW_rule__Scenario__Group__4_in_rule__Scenario__Group__31691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario__ProcessingsAssignment_3_in_rule__Scenario__Group__3__Impl1718 = new BitSet(new long[]{0x00000000098FC002L});
        public static final BitSet FOLLOW_rule__Scenario__Group__4__Impl_in_rule__Scenario__Group__41749 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Scenario__Group__4__Impl1777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__0__Impl_in_rule__PropertiesView__Group__01818 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__1_in_rule__PropertiesView__Group__01821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__PropertiesView__Group__0__Impl1849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__1__Impl_in_rule__PropertiesView__Group__11880 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__2_in_rule__PropertiesView__Group__11883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertiesView__NameAssignment_1_in_rule__PropertiesView__Group__1__Impl1910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__2__Impl_in_rule__PropertiesView__Group__21941 = new BitSet(new long[]{0x00000000098FE000L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__3_in_rule__PropertiesView__Group__21944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__PropertiesView__Group__2__Impl1972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__3__Impl_in_rule__PropertiesView__Group__32003 = new BitSet(new long[]{0x00000000098FE000L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__4_in_rule__PropertiesView__Group__32006 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertiesView__ProcessingsAssignment_3_in_rule__PropertiesView__Group__3__Impl2033 = new BitSet(new long[]{0x00000000098FC002L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__4__Impl_in_rule__PropertiesView__Group__42064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__PropertiesView__Group__4__Impl2092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wizard__Group__0__Impl_in_rule__Wizard__Group__02133 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_rule__Wizard__Group__1_in_rule__Wizard__Group__02136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Wizard__Group__0__Impl2164 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wizard__Group__1__Impl_in_rule__Wizard__Group__12195 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_rule__Wizard__Group__2_in_rule__Wizard__Group__12198 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wizard__NameAssignment_1_in_rule__Wizard__Group__1__Impl2225 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wizard__Group__2__Impl_in_rule__Wizard__Group__22256 = new BitSet(new long[]{0x00000000098FE000L});
        public static final BitSet FOLLOW_rule__Wizard__Group__3_in_rule__Wizard__Group__22259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Wizard__Group__2__Impl2287 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wizard__Group__3__Impl_in_rule__Wizard__Group__32318 = new BitSet(new long[]{0x00000000098FE000L});
        public static final BitSet FOLLOW_rule__Wizard__Group__4_in_rule__Wizard__Group__32321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wizard__ProcessingsAssignment_3_in_rule__Wizard__Group__3__Impl2348 = new BitSet(new long[]{0x00000000098FC002L});
        public static final BitSet FOLLOW_rule__Wizard__Group__4__Impl_in_rule__Wizard__Group__42379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Wizard__Group__4__Impl2407 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Details__Group__0__Impl_in_rule__Details__Group__02448 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_rule__Details__Group__1_in_rule__Details__Group__02451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Details__Group__0__Impl2479 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Details__Group__1__Impl_in_rule__Details__Group__12510 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_rule__Details__Group__2_in_rule__Details__Group__12513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Details__NameAssignment_1_in_rule__Details__Group__1__Impl2540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Details__Group__2__Impl_in_rule__Details__Group__22571 = new BitSet(new long[]{0x00000000098FE000L});
        public static final BitSet FOLLOW_rule__Details__Group__3_in_rule__Details__Group__22574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Details__Group__2__Impl2602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Details__Group__3__Impl_in_rule__Details__Group__32633 = new BitSet(new long[]{0x00000000098FE000L});
        public static final BitSet FOLLOW_rule__Details__Group__4_in_rule__Details__Group__32636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Details__ProcessingsAssignment_3_in_rule__Details__Group__3__Impl2663 = new BitSet(new long[]{0x00000000098FC002L});
        public static final BitSet FOLLOW_rule__Details__Group__4__Impl_in_rule__Details__Group__42694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Details__Group__4__Impl2722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateProject__Group__0__Impl_in_rule__CreateProject__Group__02763 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__CreateProject__Group__1_in_rule__CreateProject__Group__02766 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__CreateProject__Group__0__Impl2794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateProject__Group__1__Impl_in_rule__CreateProject__Group__12825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateProject__ProjectNameAssignment_1_in_rule__CreateProject__Group__1__Impl2852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RemoveProject__Group__0__Impl_in_rule__RemoveProject__Group__02886 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__RemoveProject__Group__1_in_rule__RemoveProject__Group__02889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__RemoveProject__Group__0__Impl2917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RemoveProject__Group__1__Impl_in_rule__RemoveProject__Group__12948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RemoveProject__ProjectNameAssignment_1_in_rule__RemoveProject__Group__1__Impl2975 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__0__Impl_in_rule__CreateModel__Group__03009 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__1_in_rule__CreateModel__Group__03012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__CreateModel__Group__0__Impl3040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__1__Impl_in_rule__CreateModel__Group__13071 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__2_in_rule__CreateModel__Group__13074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__ReferenceNameAssignment_1_in_rule__CreateModel__Group__1__Impl3101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__2__Impl_in_rule__CreateModel__Group__23131 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__3_in_rule__CreateModel__Group__23134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__CreateModel__Group__2__Impl3162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__3__Impl_in_rule__CreateModel__Group__33193 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__4_in_rule__CreateModel__Group__33196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__RootURIAssignment_3_in_rule__CreateModel__Group__3__Impl3223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__4__Impl_in_rule__CreateModel__Group__43253 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__5_in_rule__CreateModel__Group__43256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__CreateModel__Group__4__Impl3284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__5__Impl_in_rule__CreateModel__Group__53315 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__6_in_rule__CreateModel__Group__53318 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__ModelNameAssignment_5_in_rule__CreateModel__Group__5__Impl3345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__6__Impl_in_rule__CreateModel__Group__63375 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__7_in_rule__CreateModel__Group__63378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__CreateModel__Group__6__Impl3406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__Group__7__Impl_in_rule__CreateModel__Group__73437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CreateModel__PathAssignment_7_in_rule__CreateModel__Group__7__Impl3464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Save__Group__0__Impl_in_rule__Save__Group__03510 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_rule__Save__Group__1_in_rule__Save__Group__03513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__Save__Group__0__Impl3541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Save__Group__1__Impl_in_rule__Save__Group__13572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Check__Group__0__Impl_in_rule__Check__Group__03634 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_rule__Check__Group__1_in_rule__Check__Group__03637 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__Check__Group__0__Impl3665 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Check__Group__1__Impl_in_rule__Check__Group__13696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Add__Group__0__Impl_in_rule__Add__Group__03758 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Add__Group__1_in_rule__Add__Group__03761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Add__Group__0__Impl3789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Add__Group__1__Impl_in_rule__Add__Group__13820 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Add__Group__2_in_rule__Add__Group__13823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Add__ReferenceNameAssignment_1_in_rule__Add__Group__1__Impl3850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Add__Group__2__Impl_in_rule__Add__Group__23880 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Add__Group__3_in_rule__Add__Group__23883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Add__Group__2__Impl3911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Add__Group__3__Impl_in_rule__Add__Group__33942 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__Add__Group__4_in_rule__Add__Group__33945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Add__TypeURIAssignment_3_in_rule__Add__Group__3__Impl3972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Add__Group__4__Impl_in_rule__Add__Group__44002 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Add__Group__5_in_rule__Add__Group__44005 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__Add__Group__4__Impl4033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Add__Group__5__Impl_in_rule__Add__Group__54064 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Add__Group__6_in_rule__Add__Group__54067 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Add__ReferenceableObjectAssignment_5_in_rule__Add__Group__5__Impl4094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Add__Group__6__Impl_in_rule__Add__Group__64124 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Add__Group__7_in_rule__Add__Group__64127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Add__Group__6__Impl4155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Add__Group__7__Impl_in_rule__Add__Group__74186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Add__EContainingFeatureURIAssignment_7_in_rule__Add__Group__7__Impl4213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group__0__Impl_in_rule__SetAttribute__Group__04259 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group__1_in_rule__SetAttribute__Group__04262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__SetAttribute__Group__0__Impl4290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group__1__Impl_in_rule__SetAttribute__Group__14321 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group__2_in_rule__SetAttribute__Group__14324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SetAttribute__ReferenceableObjectAssignment_1_in_rule__SetAttribute__Group__1__Impl4351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group__2__Impl_in_rule__SetAttribute__Group__24381 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group__3_in_rule__SetAttribute__Group__24384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__SetAttribute__Group__2__Impl4412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group__3__Impl_in_rule__SetAttribute__Group__34443 = new BitSet(new long[]{0x0000000024000000L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group__4_in_rule__SetAttribute__Group__34446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SetAttribute__ValuesAssignment_3_in_rule__SetAttribute__Group__3__Impl4473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group__4__Impl_in_rule__SetAttribute__Group__44503 = new BitSet(new long[]{0x0000000024000000L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group__5_in_rule__SetAttribute__Group__44506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group_4__0_in_rule__SetAttribute__Group__4__Impl4533 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group__5__Impl_in_rule__SetAttribute__Group__54564 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group__6_in_rule__SetAttribute__Group__54567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__SetAttribute__Group__5__Impl4595 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group__6__Impl_in_rule__SetAttribute__Group__64626 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group__7_in_rule__SetAttribute__Group__64629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SetAttribute__EContainingFeatureURIAssignment_6_in_rule__SetAttribute__Group__6__Impl4656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group__7__Impl_in_rule__SetAttribute__Group__74686 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group_7__0_in_rule__SetAttribute__Group__7__Impl4713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group_4__0__Impl_in_rule__SetAttribute__Group_4__04760 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group_4__1_in_rule__SetAttribute__Group_4__04763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__SetAttribute__Group_4__0__Impl4791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group_4__1__Impl_in_rule__SetAttribute__Group_4__14822 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SetAttribute__ValuesAssignment_4_1_in_rule__SetAttribute__Group_4__1__Impl4849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group_7__0__Impl_in_rule__SetAttribute__Group_7__04883 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group_7__1_in_rule__SetAttribute__Group_7__04886 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__SetAttribute__Group_7__0__Impl4914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SetAttribute__Group_7__1__Impl_in_rule__SetAttribute__Group_7__14945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SetAttribute__PropertiesEditionElementURIAssignment_7_1_in_rule__SetAttribute__Group_7__1__Impl4972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Scenario__NameAssignment_15011 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProcessings_in_rule__Scenario__ProcessingsAssignment_35042 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__PropertiesView__NameAssignment_15073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubProcessings_in_rule__PropertiesView__ProcessingsAssignment_35104 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Wizard__NameAssignment_15135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubProcessings_in_rule__Wizard__ProcessingsAssignment_35166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Details__NameAssignment_15197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubProcessings_in_rule__Details__ProcessingsAssignment_35228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__CreateProject__ProjectNameAssignment_15259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__RemoveProject__ProjectNameAssignment_15290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__CreateModel__ReferenceNameAssignment_15321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__CreateModel__RootURIAssignment_35352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__CreateModel__ModelNameAssignment_55383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__CreateModel__PathAssignment_75414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Add__ReferenceNameAssignment_15445 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Add__TypeURIAssignment_35476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Add__ReferenceableObjectAssignment_55511 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Add__EContainingFeatureURIAssignment_75546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SetAttribute__ReferenceableObjectAssignment_15581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__SetAttribute__ValuesAssignment_35616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__SetAttribute__ValuesAssignment_4_15647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__SetAttribute__EContainingFeatureURIAssignment_65678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__SetAttribute__PropertiesEditionElementURIAssignment_7_15709 = new BitSet(new long[]{0x0000000000000002L});
    }


}