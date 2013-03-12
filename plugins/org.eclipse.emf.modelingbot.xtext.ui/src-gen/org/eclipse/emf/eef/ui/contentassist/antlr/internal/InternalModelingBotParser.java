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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'scenario'", "'{'", "'}'", "'propertiesView'", "'wizard'", "'detailsPage'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

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


    // $ANTLR start "entryRuleEEFProcessings"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:88:1: entryRuleEEFProcessings : ruleEEFProcessings EOF ;
    public final void entryRuleEEFProcessings() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:89:1: ( ruleEEFProcessings EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:90:1: ruleEEFProcessings EOF
            {
             before(grammarAccess.getEEFProcessingsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEEFProcessings_in_entryRuleEEFProcessings121);
            ruleEEFProcessings();

            state._fsp--;

             after(grammarAccess.getEEFProcessingsRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEEFProcessings128); 

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
    // $ANTLR end "entryRuleEEFProcessings"


    // $ANTLR start "ruleEEFProcessings"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:97:1: ruleEEFProcessings : ( ( rule__EEFProcessings__Alternatives ) ) ;
    public final void ruleEEFProcessings() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:101:2: ( ( ( rule__EEFProcessings__Alternatives ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:102:1: ( ( rule__EEFProcessings__Alternatives ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:102:1: ( ( rule__EEFProcessings__Alternatives ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:103:1: ( rule__EEFProcessings__Alternatives )
            {
             before(grammarAccess.getEEFProcessingsAccess().getAlternatives()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:104:1: ( rule__EEFProcessings__Alternatives )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:104:2: rule__EEFProcessings__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EEFProcessings__Alternatives_in_ruleEEFProcessings154);
            rule__EEFProcessings__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEEFProcessingsAccess().getAlternatives()); 

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
    // $ANTLR end "ruleEEFProcessings"


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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:209:1: ruleSubProcessings : ( ruleWizard ) ;
    public final void ruleSubProcessings() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:213:2: ( ( ruleWizard ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:214:1: ( ruleWizard )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:214:1: ( ruleWizard )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:215:1: ruleWizard
            {
             before(grammarAccess.getSubProcessingsAccess().getWizardParserRuleCall()); 
            pushFollow(FollowSets000.FOLLOW_ruleWizard_in_ruleSubProcessings394);
            ruleWizard();

            state._fsp--;

             after(grammarAccess.getSubProcessingsAccess().getWizardParserRuleCall()); 

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


    // $ANTLR start "entryRuleEString"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:228:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:229:1: ( ruleEString EOF )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:230:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString420);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString427); 

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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:237:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:241:2: ( ( ( rule__EString__Alternatives ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:242:1: ( ( rule__EString__Alternatives ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:242:1: ( ( rule__EString__Alternatives ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:243:1: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:244:1: ( rule__EString__Alternatives )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:244:2: rule__EString__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EString__Alternatives_in_ruleEString453);
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


    // $ANTLR start "rule__EEFProcessings__Alternatives"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:256:1: rule__EEFProcessings__Alternatives : ( ( ruleDetails ) | ( ruleWizard ) | ( rulePropertiesView ) );
    public final void rule__EEFProcessings__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:260:1: ( ( ruleDetails ) | ( ruleWizard ) | ( rulePropertiesView ) )
            int alt1=3;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:261:1: ( ruleDetails )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:261:1: ( ruleDetails )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:262:1: ruleDetails
                    {
                     before(grammarAccess.getEEFProcessingsAccess().getDetailsParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleDetails_in_rule__EEFProcessings__Alternatives489);
                    ruleDetails();

                    state._fsp--;

                     after(grammarAccess.getEEFProcessingsAccess().getDetailsParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:267:6: ( ruleWizard )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:267:6: ( ruleWizard )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:268:1: ruleWizard
                    {
                     before(grammarAccess.getEEFProcessingsAccess().getWizardParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleWizard_in_rule__EEFProcessings__Alternatives506);
                    ruleWizard();

                    state._fsp--;

                     after(grammarAccess.getEEFProcessingsAccess().getWizardParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:273:6: ( rulePropertiesView )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:273:6: ( rulePropertiesView )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:274:1: rulePropertiesView
                    {
                     before(grammarAccess.getEEFProcessingsAccess().getPropertiesViewParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_rulePropertiesView_in_rule__EEFProcessings__Alternatives523);
                    rulePropertiesView();

                    state._fsp--;

                     after(grammarAccess.getEEFProcessingsAccess().getPropertiesViewParserRuleCall_2()); 

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
    // $ANTLR end "rule__EEFProcessings__Alternatives"


    // $ANTLR start "rule__EString__Alternatives"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:284:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:288:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:289:1: ( RULE_STRING )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:289:1: ( RULE_STRING )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:290:1: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EString__Alternatives555); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:295:6: ( RULE_ID )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:295:6: ( RULE_ID )
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:296:1: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EString__Alternatives572); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:308:1: rule__Scenario__Group__0 : rule__Scenario__Group__0__Impl rule__Scenario__Group__1 ;
    public final void rule__Scenario__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:312:1: ( rule__Scenario__Group__0__Impl rule__Scenario__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:313:2: rule__Scenario__Group__0__Impl rule__Scenario__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__0__Impl_in_rule__Scenario__Group__0602);
            rule__Scenario__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__1_in_rule__Scenario__Group__0605);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:320:1: rule__Scenario__Group__0__Impl : ( 'scenario' ) ;
    public final void rule__Scenario__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:324:1: ( ( 'scenario' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:325:1: ( 'scenario' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:325:1: ( 'scenario' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:326:1: 'scenario'
            {
             before(grammarAccess.getScenarioAccess().getScenarioKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Scenario__Group__0__Impl633); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:339:1: rule__Scenario__Group__1 : rule__Scenario__Group__1__Impl rule__Scenario__Group__2 ;
    public final void rule__Scenario__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:343:1: ( rule__Scenario__Group__1__Impl rule__Scenario__Group__2 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:344:2: rule__Scenario__Group__1__Impl rule__Scenario__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__1__Impl_in_rule__Scenario__Group__1664);
            rule__Scenario__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__2_in_rule__Scenario__Group__1667);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:351:1: rule__Scenario__Group__1__Impl : ( ( rule__Scenario__NameAssignment_1 ) ) ;
    public final void rule__Scenario__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:355:1: ( ( ( rule__Scenario__NameAssignment_1 ) ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:356:1: ( ( rule__Scenario__NameAssignment_1 ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:356:1: ( ( rule__Scenario__NameAssignment_1 ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:357:1: ( rule__Scenario__NameAssignment_1 )
            {
             before(grammarAccess.getScenarioAccess().getNameAssignment_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:358:1: ( rule__Scenario__NameAssignment_1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:358:2: rule__Scenario__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario__NameAssignment_1_in_rule__Scenario__Group__1__Impl694);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:368:1: rule__Scenario__Group__2 : rule__Scenario__Group__2__Impl rule__Scenario__Group__3 ;
    public final void rule__Scenario__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:372:1: ( rule__Scenario__Group__2__Impl rule__Scenario__Group__3 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:373:2: rule__Scenario__Group__2__Impl rule__Scenario__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__2__Impl_in_rule__Scenario__Group__2724);
            rule__Scenario__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__3_in_rule__Scenario__Group__2727);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:380:1: rule__Scenario__Group__2__Impl : ( '{' ) ;
    public final void rule__Scenario__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:384:1: ( ( '{' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:385:1: ( '{' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:385:1: ( '{' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:386:1: '{'
            {
             before(grammarAccess.getScenarioAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Scenario__Group__2__Impl755); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:399:1: rule__Scenario__Group__3 : rule__Scenario__Group__3__Impl rule__Scenario__Group__4 ;
    public final void rule__Scenario__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:403:1: ( rule__Scenario__Group__3__Impl rule__Scenario__Group__4 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:404:2: rule__Scenario__Group__3__Impl rule__Scenario__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__3__Impl_in_rule__Scenario__Group__3786);
            rule__Scenario__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__4_in_rule__Scenario__Group__3789);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:411:1: rule__Scenario__Group__3__Impl : ( ( rule__Scenario__ProcessingsAssignment_3 )* ) ;
    public final void rule__Scenario__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:415:1: ( ( ( rule__Scenario__ProcessingsAssignment_3 )* ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:416:1: ( ( rule__Scenario__ProcessingsAssignment_3 )* )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:416:1: ( ( rule__Scenario__ProcessingsAssignment_3 )* )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:417:1: ( rule__Scenario__ProcessingsAssignment_3 )*
            {
             before(grammarAccess.getScenarioAccess().getProcessingsAssignment_3()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:418:1: ( rule__Scenario__ProcessingsAssignment_3 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=14 && LA3_0<=16)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:418:2: rule__Scenario__ProcessingsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Scenario__ProcessingsAssignment_3_in_rule__Scenario__Group__3__Impl816);
            	    rule__Scenario__ProcessingsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:428:1: rule__Scenario__Group__4 : rule__Scenario__Group__4__Impl ;
    public final void rule__Scenario__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:432:1: ( rule__Scenario__Group__4__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:433:2: rule__Scenario__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scenario__Group__4__Impl_in_rule__Scenario__Group__4847);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:439:1: rule__Scenario__Group__4__Impl : ( '}' ) ;
    public final void rule__Scenario__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:443:1: ( ( '}' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:444:1: ( '}' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:444:1: ( '}' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:445:1: '}'
            {
             before(grammarAccess.getScenarioAccess().getRightCurlyBracketKeyword_4()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Scenario__Group__4__Impl875); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:468:1: rule__PropertiesView__Group__0 : rule__PropertiesView__Group__0__Impl rule__PropertiesView__Group__1 ;
    public final void rule__PropertiesView__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:472:1: ( rule__PropertiesView__Group__0__Impl rule__PropertiesView__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:473:2: rule__PropertiesView__Group__0__Impl rule__PropertiesView__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__0__Impl_in_rule__PropertiesView__Group__0916);
            rule__PropertiesView__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__1_in_rule__PropertiesView__Group__0919);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:480:1: rule__PropertiesView__Group__0__Impl : ( 'propertiesView' ) ;
    public final void rule__PropertiesView__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:484:1: ( ( 'propertiesView' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:485:1: ( 'propertiesView' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:485:1: ( 'propertiesView' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:486:1: 'propertiesView'
            {
             before(grammarAccess.getPropertiesViewAccess().getPropertiesViewKeyword_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__PropertiesView__Group__0__Impl947); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:499:1: rule__PropertiesView__Group__1 : rule__PropertiesView__Group__1__Impl rule__PropertiesView__Group__2 ;
    public final void rule__PropertiesView__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:503:1: ( rule__PropertiesView__Group__1__Impl rule__PropertiesView__Group__2 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:504:2: rule__PropertiesView__Group__1__Impl rule__PropertiesView__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__1__Impl_in_rule__PropertiesView__Group__1978);
            rule__PropertiesView__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__2_in_rule__PropertiesView__Group__1981);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:511:1: rule__PropertiesView__Group__1__Impl : ( ( rule__PropertiesView__NameAssignment_1 )? ) ;
    public final void rule__PropertiesView__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:515:1: ( ( ( rule__PropertiesView__NameAssignment_1 )? ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:516:1: ( ( rule__PropertiesView__NameAssignment_1 )? )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:516:1: ( ( rule__PropertiesView__NameAssignment_1 )? )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:517:1: ( rule__PropertiesView__NameAssignment_1 )?
            {
             before(grammarAccess.getPropertiesViewAccess().getNameAssignment_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:518:1: ( rule__PropertiesView__NameAssignment_1 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=RULE_STRING && LA4_0<=RULE_ID)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:518:2: rule__PropertiesView__NameAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__NameAssignment_1_in_rule__PropertiesView__Group__1__Impl1008);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:528:1: rule__PropertiesView__Group__2 : rule__PropertiesView__Group__2__Impl rule__PropertiesView__Group__3 ;
    public final void rule__PropertiesView__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:532:1: ( rule__PropertiesView__Group__2__Impl rule__PropertiesView__Group__3 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:533:2: rule__PropertiesView__Group__2__Impl rule__PropertiesView__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__2__Impl_in_rule__PropertiesView__Group__21039);
            rule__PropertiesView__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__3_in_rule__PropertiesView__Group__21042);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:540:1: rule__PropertiesView__Group__2__Impl : ( '{' ) ;
    public final void rule__PropertiesView__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:544:1: ( ( '{' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:545:1: ( '{' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:545:1: ( '{' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:546:1: '{'
            {
             before(grammarAccess.getPropertiesViewAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__PropertiesView__Group__2__Impl1070); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:559:1: rule__PropertiesView__Group__3 : rule__PropertiesView__Group__3__Impl rule__PropertiesView__Group__4 ;
    public final void rule__PropertiesView__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:563:1: ( rule__PropertiesView__Group__3__Impl rule__PropertiesView__Group__4 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:564:2: rule__PropertiesView__Group__3__Impl rule__PropertiesView__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__3__Impl_in_rule__PropertiesView__Group__31101);
            rule__PropertiesView__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__4_in_rule__PropertiesView__Group__31104);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:571:1: rule__PropertiesView__Group__3__Impl : ( ( rule__PropertiesView__ProcessingsAssignment_3 )* ) ;
    public final void rule__PropertiesView__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:575:1: ( ( ( rule__PropertiesView__ProcessingsAssignment_3 )* ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:576:1: ( ( rule__PropertiesView__ProcessingsAssignment_3 )* )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:576:1: ( ( rule__PropertiesView__ProcessingsAssignment_3 )* )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:577:1: ( rule__PropertiesView__ProcessingsAssignment_3 )*
            {
             before(grammarAccess.getPropertiesViewAccess().getProcessingsAssignment_3()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:578:1: ( rule__PropertiesView__ProcessingsAssignment_3 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:578:2: rule__PropertiesView__ProcessingsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__ProcessingsAssignment_3_in_rule__PropertiesView__Group__3__Impl1131);
            	    rule__PropertiesView__ProcessingsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:588:1: rule__PropertiesView__Group__4 : rule__PropertiesView__Group__4__Impl ;
    public final void rule__PropertiesView__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:592:1: ( rule__PropertiesView__Group__4__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:593:2: rule__PropertiesView__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertiesView__Group__4__Impl_in_rule__PropertiesView__Group__41162);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:599:1: rule__PropertiesView__Group__4__Impl : ( '}' ) ;
    public final void rule__PropertiesView__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:603:1: ( ( '}' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:604:1: ( '}' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:604:1: ( '}' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:605:1: '}'
            {
             before(grammarAccess.getPropertiesViewAccess().getRightCurlyBracketKeyword_4()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__PropertiesView__Group__4__Impl1190); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:628:1: rule__Wizard__Group__0 : rule__Wizard__Group__0__Impl rule__Wizard__Group__1 ;
    public final void rule__Wizard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:632:1: ( rule__Wizard__Group__0__Impl rule__Wizard__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:633:2: rule__Wizard__Group__0__Impl rule__Wizard__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__0__Impl_in_rule__Wizard__Group__01231);
            rule__Wizard__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__1_in_rule__Wizard__Group__01234);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:640:1: rule__Wizard__Group__0__Impl : ( 'wizard' ) ;
    public final void rule__Wizard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:644:1: ( ( 'wizard' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:645:1: ( 'wizard' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:645:1: ( 'wizard' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:646:1: 'wizard'
            {
             before(grammarAccess.getWizardAccess().getWizardKeyword_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Wizard__Group__0__Impl1262); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:659:1: rule__Wizard__Group__1 : rule__Wizard__Group__1__Impl rule__Wizard__Group__2 ;
    public final void rule__Wizard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:663:1: ( rule__Wizard__Group__1__Impl rule__Wizard__Group__2 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:664:2: rule__Wizard__Group__1__Impl rule__Wizard__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__1__Impl_in_rule__Wizard__Group__11293);
            rule__Wizard__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__2_in_rule__Wizard__Group__11296);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:671:1: rule__Wizard__Group__1__Impl : ( ( rule__Wizard__NameAssignment_1 )? ) ;
    public final void rule__Wizard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:675:1: ( ( ( rule__Wizard__NameAssignment_1 )? ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:676:1: ( ( rule__Wizard__NameAssignment_1 )? )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:676:1: ( ( rule__Wizard__NameAssignment_1 )? )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:677:1: ( rule__Wizard__NameAssignment_1 )?
            {
             before(grammarAccess.getWizardAccess().getNameAssignment_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:678:1: ( rule__Wizard__NameAssignment_1 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=RULE_STRING && LA6_0<=RULE_ID)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:678:2: rule__Wizard__NameAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Wizard__NameAssignment_1_in_rule__Wizard__Group__1__Impl1323);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:688:1: rule__Wizard__Group__2 : rule__Wizard__Group__2__Impl rule__Wizard__Group__3 ;
    public final void rule__Wizard__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:692:1: ( rule__Wizard__Group__2__Impl rule__Wizard__Group__3 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:693:2: rule__Wizard__Group__2__Impl rule__Wizard__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__2__Impl_in_rule__Wizard__Group__21354);
            rule__Wizard__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__3_in_rule__Wizard__Group__21357);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:700:1: rule__Wizard__Group__2__Impl : ( '{' ) ;
    public final void rule__Wizard__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:704:1: ( ( '{' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:705:1: ( '{' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:705:1: ( '{' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:706:1: '{'
            {
             before(grammarAccess.getWizardAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Wizard__Group__2__Impl1385); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:719:1: rule__Wizard__Group__3 : rule__Wizard__Group__3__Impl rule__Wizard__Group__4 ;
    public final void rule__Wizard__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:723:1: ( rule__Wizard__Group__3__Impl rule__Wizard__Group__4 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:724:2: rule__Wizard__Group__3__Impl rule__Wizard__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__3__Impl_in_rule__Wizard__Group__31416);
            rule__Wizard__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__4_in_rule__Wizard__Group__31419);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:731:1: rule__Wizard__Group__3__Impl : ( ( rule__Wizard__ProcessingsAssignment_3 )* ) ;
    public final void rule__Wizard__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:735:1: ( ( ( rule__Wizard__ProcessingsAssignment_3 )* ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:736:1: ( ( rule__Wizard__ProcessingsAssignment_3 )* )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:736:1: ( ( rule__Wizard__ProcessingsAssignment_3 )* )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:737:1: ( rule__Wizard__ProcessingsAssignment_3 )*
            {
             before(grammarAccess.getWizardAccess().getProcessingsAssignment_3()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:738:1: ( rule__Wizard__ProcessingsAssignment_3 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==15) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:738:2: rule__Wizard__ProcessingsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Wizard__ProcessingsAssignment_3_in_rule__Wizard__Group__3__Impl1446);
            	    rule__Wizard__ProcessingsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:748:1: rule__Wizard__Group__4 : rule__Wizard__Group__4__Impl ;
    public final void rule__Wizard__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:752:1: ( rule__Wizard__Group__4__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:753:2: rule__Wizard__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wizard__Group__4__Impl_in_rule__Wizard__Group__41477);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:759:1: rule__Wizard__Group__4__Impl : ( '}' ) ;
    public final void rule__Wizard__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:763:1: ( ( '}' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:764:1: ( '}' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:764:1: ( '}' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:765:1: '}'
            {
             before(grammarAccess.getWizardAccess().getRightCurlyBracketKeyword_4()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Wizard__Group__4__Impl1505); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:788:1: rule__Details__Group__0 : rule__Details__Group__0__Impl rule__Details__Group__1 ;
    public final void rule__Details__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:792:1: ( rule__Details__Group__0__Impl rule__Details__Group__1 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:793:2: rule__Details__Group__0__Impl rule__Details__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__0__Impl_in_rule__Details__Group__01546);
            rule__Details__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__1_in_rule__Details__Group__01549);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:800:1: rule__Details__Group__0__Impl : ( 'detailsPage' ) ;
    public final void rule__Details__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:804:1: ( ( 'detailsPage' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:805:1: ( 'detailsPage' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:805:1: ( 'detailsPage' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:806:1: 'detailsPage'
            {
             before(grammarAccess.getDetailsAccess().getDetailsPageKeyword_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Details__Group__0__Impl1577); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:819:1: rule__Details__Group__1 : rule__Details__Group__1__Impl rule__Details__Group__2 ;
    public final void rule__Details__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:823:1: ( rule__Details__Group__1__Impl rule__Details__Group__2 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:824:2: rule__Details__Group__1__Impl rule__Details__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__1__Impl_in_rule__Details__Group__11608);
            rule__Details__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__2_in_rule__Details__Group__11611);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:831:1: rule__Details__Group__1__Impl : ( ( rule__Details__NameAssignment_1 )? ) ;
    public final void rule__Details__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:835:1: ( ( ( rule__Details__NameAssignment_1 )? ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:836:1: ( ( rule__Details__NameAssignment_1 )? )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:836:1: ( ( rule__Details__NameAssignment_1 )? )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:837:1: ( rule__Details__NameAssignment_1 )?
            {
             before(grammarAccess.getDetailsAccess().getNameAssignment_1()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:838:1: ( rule__Details__NameAssignment_1 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_STRING && LA8_0<=RULE_ID)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:838:2: rule__Details__NameAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Details__NameAssignment_1_in_rule__Details__Group__1__Impl1638);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:848:1: rule__Details__Group__2 : rule__Details__Group__2__Impl rule__Details__Group__3 ;
    public final void rule__Details__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:852:1: ( rule__Details__Group__2__Impl rule__Details__Group__3 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:853:2: rule__Details__Group__2__Impl rule__Details__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__2__Impl_in_rule__Details__Group__21669);
            rule__Details__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__3_in_rule__Details__Group__21672);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:860:1: rule__Details__Group__2__Impl : ( '{' ) ;
    public final void rule__Details__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:864:1: ( ( '{' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:865:1: ( '{' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:865:1: ( '{' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:866:1: '{'
            {
             before(grammarAccess.getDetailsAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Details__Group__2__Impl1700); 
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:879:1: rule__Details__Group__3 : rule__Details__Group__3__Impl rule__Details__Group__4 ;
    public final void rule__Details__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:883:1: ( rule__Details__Group__3__Impl rule__Details__Group__4 )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:884:2: rule__Details__Group__3__Impl rule__Details__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__3__Impl_in_rule__Details__Group__31731);
            rule__Details__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__4_in_rule__Details__Group__31734);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:891:1: rule__Details__Group__3__Impl : ( ( rule__Details__ProcessingsAssignment_3 )* ) ;
    public final void rule__Details__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:895:1: ( ( ( rule__Details__ProcessingsAssignment_3 )* ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:896:1: ( ( rule__Details__ProcessingsAssignment_3 )* )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:896:1: ( ( rule__Details__ProcessingsAssignment_3 )* )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:897:1: ( rule__Details__ProcessingsAssignment_3 )*
            {
             before(grammarAccess.getDetailsAccess().getProcessingsAssignment_3()); 
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:898:1: ( rule__Details__ProcessingsAssignment_3 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==15) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:898:2: rule__Details__ProcessingsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Details__ProcessingsAssignment_3_in_rule__Details__Group__3__Impl1761);
            	    rule__Details__ProcessingsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:908:1: rule__Details__Group__4 : rule__Details__Group__4__Impl ;
    public final void rule__Details__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:912:1: ( rule__Details__Group__4__Impl )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:913:2: rule__Details__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Details__Group__4__Impl_in_rule__Details__Group__41792);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:919:1: rule__Details__Group__4__Impl : ( '}' ) ;
    public final void rule__Details__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:923:1: ( ( '}' ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:924:1: ( '}' )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:924:1: ( '}' )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:925:1: '}'
            {
             before(grammarAccess.getDetailsAccess().getRightCurlyBracketKeyword_4()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Details__Group__4__Impl1820); 
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


    // $ANTLR start "rule__Scenario__NameAssignment_1"
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:949:1: rule__Scenario__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Scenario__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:953:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:954:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:954:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:955:1: ruleEString
            {
             before(grammarAccess.getScenarioAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Scenario__NameAssignment_11866);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:964:1: rule__Scenario__ProcessingsAssignment_3 : ( ruleEEFProcessings ) ;
    public final void rule__Scenario__ProcessingsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:968:1: ( ( ruleEEFProcessings ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:969:1: ( ruleEEFProcessings )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:969:1: ( ruleEEFProcessings )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:970:1: ruleEEFProcessings
            {
             before(grammarAccess.getScenarioAccess().getProcessingsEEFProcessingsParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEEFProcessings_in_rule__Scenario__ProcessingsAssignment_31897);
            ruleEEFProcessings();

            state._fsp--;

             after(grammarAccess.getScenarioAccess().getProcessingsEEFProcessingsParserRuleCall_3_0()); 

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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:979:1: rule__PropertiesView__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__PropertiesView__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:983:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:984:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:984:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:985:1: ruleEString
            {
             before(grammarAccess.getPropertiesViewAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__PropertiesView__NameAssignment_11928);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:994:1: rule__PropertiesView__ProcessingsAssignment_3 : ( ruleSubProcessings ) ;
    public final void rule__PropertiesView__ProcessingsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:998:1: ( ( ruleSubProcessings ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:999:1: ( ruleSubProcessings )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:999:1: ( ruleSubProcessings )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1000:1: ruleSubProcessings
            {
             before(grammarAccess.getPropertiesViewAccess().getProcessingsSubProcessingsParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubProcessings_in_rule__PropertiesView__ProcessingsAssignment_31959);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1009:1: rule__Wizard__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Wizard__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1013:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1014:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1014:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1015:1: ruleEString
            {
             before(grammarAccess.getWizardAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Wizard__NameAssignment_11990);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1024:1: rule__Wizard__ProcessingsAssignment_3 : ( ruleSubProcessings ) ;
    public final void rule__Wizard__ProcessingsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1028:1: ( ( ruleSubProcessings ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1029:1: ( ruleSubProcessings )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1029:1: ( ruleSubProcessings )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1030:1: ruleSubProcessings
            {
             before(grammarAccess.getWizardAccess().getProcessingsSubProcessingsParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubProcessings_in_rule__Wizard__ProcessingsAssignment_32021);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1039:1: rule__Details__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Details__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1043:1: ( ( ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1044:1: ( ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1044:1: ( ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1045:1: ruleEString
            {
             before(grammarAccess.getDetailsAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Details__NameAssignment_12052);
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
    // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1054:1: rule__Details__ProcessingsAssignment_3 : ( ruleSubProcessings ) ;
    public final void rule__Details__ProcessingsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1058:1: ( ( ruleSubProcessings ) )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1059:1: ( ruleSubProcessings )
            {
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1059:1: ( ruleSubProcessings )
            // ../org.eclipse.emf.modelingbot.xtext.ui/src-gen/org/eclipse/emf/eef/ui/contentassist/antlr/internal/InternalModelingBot.g:1060:1: ruleSubProcessings
            {
             before(grammarAccess.getDetailsAccess().getProcessingsSubProcessingsParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubProcessings_in_rule__Details__ProcessingsAssignment_32083);
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

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleScenario_in_entryRuleScenario61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario__Group__0_in_ruleScenario94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEFProcessings_in_entryRuleEEFProcessings121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEEFProcessings128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EEFProcessings__Alternatives_in_ruleEEFProcessings154 = new BitSet(new long[]{0x0000000000000002L});
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
        public static final BitSet FOLLOW_ruleWizard_in_ruleSubProcessings394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString420 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EString__Alternatives_in_ruleEString453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDetails_in_rule__EEFProcessings__Alternatives489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWizard_in_rule__EEFProcessings__Alternatives506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertiesView_in_rule__EEFProcessings__Alternatives523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EString__Alternatives555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EString__Alternatives572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario__Group__0__Impl_in_rule__Scenario__Group__0602 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Scenario__Group__1_in_rule__Scenario__Group__0605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Scenario__Group__0__Impl633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario__Group__1__Impl_in_rule__Scenario__Group__1664 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Scenario__Group__2_in_rule__Scenario__Group__1667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario__NameAssignment_1_in_rule__Scenario__Group__1__Impl694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario__Group__2__Impl_in_rule__Scenario__Group__2724 = new BitSet(new long[]{0x000000000001E000L});
        public static final BitSet FOLLOW_rule__Scenario__Group__3_in_rule__Scenario__Group__2727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Scenario__Group__2__Impl755 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario__Group__3__Impl_in_rule__Scenario__Group__3786 = new BitSet(new long[]{0x000000000001E000L});
        public static final BitSet FOLLOW_rule__Scenario__Group__4_in_rule__Scenario__Group__3789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scenario__ProcessingsAssignment_3_in_rule__Scenario__Group__3__Impl816 = new BitSet(new long[]{0x000000000001C002L});
        public static final BitSet FOLLOW_rule__Scenario__Group__4__Impl_in_rule__Scenario__Group__4847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Scenario__Group__4__Impl875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__0__Impl_in_rule__PropertiesView__Group__0916 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__1_in_rule__PropertiesView__Group__0919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__PropertiesView__Group__0__Impl947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__1__Impl_in_rule__PropertiesView__Group__1978 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__2_in_rule__PropertiesView__Group__1981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertiesView__NameAssignment_1_in_rule__PropertiesView__Group__1__Impl1008 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__2__Impl_in_rule__PropertiesView__Group__21039 = new BitSet(new long[]{0x000000000000A000L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__3_in_rule__PropertiesView__Group__21042 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__PropertiesView__Group__2__Impl1070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__3__Impl_in_rule__PropertiesView__Group__31101 = new BitSet(new long[]{0x000000000000A000L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__4_in_rule__PropertiesView__Group__31104 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertiesView__ProcessingsAssignment_3_in_rule__PropertiesView__Group__3__Impl1131 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_rule__PropertiesView__Group__4__Impl_in_rule__PropertiesView__Group__41162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__PropertiesView__Group__4__Impl1190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wizard__Group__0__Impl_in_rule__Wizard__Group__01231 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_rule__Wizard__Group__1_in_rule__Wizard__Group__01234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Wizard__Group__0__Impl1262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wizard__Group__1__Impl_in_rule__Wizard__Group__11293 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_rule__Wizard__Group__2_in_rule__Wizard__Group__11296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wizard__NameAssignment_1_in_rule__Wizard__Group__1__Impl1323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wizard__Group__2__Impl_in_rule__Wizard__Group__21354 = new BitSet(new long[]{0x000000000000A000L});
        public static final BitSet FOLLOW_rule__Wizard__Group__3_in_rule__Wizard__Group__21357 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Wizard__Group__2__Impl1385 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wizard__Group__3__Impl_in_rule__Wizard__Group__31416 = new BitSet(new long[]{0x000000000000A000L});
        public static final BitSet FOLLOW_rule__Wizard__Group__4_in_rule__Wizard__Group__31419 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wizard__ProcessingsAssignment_3_in_rule__Wizard__Group__3__Impl1446 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_rule__Wizard__Group__4__Impl_in_rule__Wizard__Group__41477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Wizard__Group__4__Impl1505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Details__Group__0__Impl_in_rule__Details__Group__01546 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_rule__Details__Group__1_in_rule__Details__Group__01549 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Details__Group__0__Impl1577 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Details__Group__1__Impl_in_rule__Details__Group__11608 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_rule__Details__Group__2_in_rule__Details__Group__11611 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Details__NameAssignment_1_in_rule__Details__Group__1__Impl1638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Details__Group__2__Impl_in_rule__Details__Group__21669 = new BitSet(new long[]{0x000000000000A000L});
        public static final BitSet FOLLOW_rule__Details__Group__3_in_rule__Details__Group__21672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Details__Group__2__Impl1700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Details__Group__3__Impl_in_rule__Details__Group__31731 = new BitSet(new long[]{0x000000000000A000L});
        public static final BitSet FOLLOW_rule__Details__Group__4_in_rule__Details__Group__31734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Details__ProcessingsAssignment_3_in_rule__Details__Group__3__Impl1761 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_rule__Details__Group__4__Impl_in_rule__Details__Group__41792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Details__Group__4__Impl1820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Scenario__NameAssignment_11866 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEFProcessings_in_rule__Scenario__ProcessingsAssignment_31897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__PropertiesView__NameAssignment_11928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubProcessings_in_rule__PropertiesView__ProcessingsAssignment_31959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Wizard__NameAssignment_11990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubProcessings_in_rule__Wizard__ProcessingsAssignment_32021 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Details__NameAssignment_12052 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubProcessings_in_rule__Details__ProcessingsAssignment_32083 = new BitSet(new long[]{0x0000000000000002L});
    }


}