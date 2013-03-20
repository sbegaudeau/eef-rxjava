package org.eclipse.emf.eef.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.emf.eef.services.ModelingBotGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalModelingBotParser extends AbstractInternalAntlrParser {
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
    public String getGrammarFileName() { return "../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g"; }



     	private ModelingBotGrammarAccess grammarAccess;
     	
        public InternalModelingBotParser(TokenStream input, ModelingBotGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Scenario";	
       	}
       	
       	@Override
       	protected ModelingBotGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleScenario"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:67:1: entryRuleScenario returns [EObject current=null] : iv_ruleScenario= ruleScenario EOF ;
    public final EObject entryRuleScenario() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario = null;


        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:68:2: (iv_ruleScenario= ruleScenario EOF )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:69:2: iv_ruleScenario= ruleScenario EOF
            {
             newCompositeNode(grammarAccess.getScenarioRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario_in_entryRuleScenario75);
            iv_ruleScenario=ruleScenario();

            state._fsp--;

             current =iv_ruleScenario; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario"


    // $ANTLR start "ruleScenario"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:76:1: ruleScenario returns [EObject current=null] : (otherlv_0= 'scenario' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' ( (lv_processings_3_0= ruleProcessings ) )* otherlv_4= '}' ) ;
    public final EObject ruleScenario() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_processings_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:79:28: ( (otherlv_0= 'scenario' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' ( (lv_processings_3_0= ruleProcessings ) )* otherlv_4= '}' ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:80:1: (otherlv_0= 'scenario' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' ( (lv_processings_3_0= ruleProcessings ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:80:1: (otherlv_0= 'scenario' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' ( (lv_processings_3_0= ruleProcessings ) )* otherlv_4= '}' )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:80:3: otherlv_0= 'scenario' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' ( (lv_processings_3_0= ruleProcessings ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleScenario122); 

                	newLeafNode(otherlv_0, grammarAccess.getScenarioAccess().getScenarioKeyword_0());
                
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:84:1: ( (lv_name_1_0= ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:85:1: (lv_name_1_0= ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:85:1: (lv_name_1_0= ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:86:3: lv_name_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getScenarioAccess().getNameEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleScenario143);
            lv_name_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getScenarioRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleScenario155); 

                	newLeafNode(otherlv_2, grammarAccess.getScenarioAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:106:1: ( (lv_processings_3_0= ruleProcessings ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=14 && LA1_0<=18)||LA1_0==21) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:107:1: (lv_processings_3_0= ruleProcessings )
            	    {
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:107:1: (lv_processings_3_0= ruleProcessings )
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:108:3: lv_processings_3_0= ruleProcessings
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScenarioAccess().getProcessingsProcessingsParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleProcessings_in_ruleScenario176);
            	    lv_processings_3_0=ruleProcessings();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScenarioRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"processings",
            	            		lv_processings_3_0, 
            	            		"Processings");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleScenario189); 

                	newLeafNode(otherlv_4, grammarAccess.getScenarioAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenario"


    // $ANTLR start "entryRuleProcessings"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:136:1: entryRuleProcessings returns [EObject current=null] : iv_ruleProcessings= ruleProcessings EOF ;
    public final EObject entryRuleProcessings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessings = null;


        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:137:2: (iv_ruleProcessings= ruleProcessings EOF )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:138:2: iv_ruleProcessings= ruleProcessings EOF
            {
             newCompositeNode(grammarAccess.getProcessingsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleProcessings_in_entryRuleProcessings225);
            iv_ruleProcessings=ruleProcessings();

            state._fsp--;

             current =iv_ruleProcessings; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProcessings235); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcessings"


    // $ANTLR start "ruleProcessings"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:145:1: ruleProcessings returns [EObject current=null] : (this_Details_0= ruleDetails | this_Wizard_1= ruleWizard | this_PropertiesView_2= rulePropertiesView | this_Action_3= ruleAction ) ;
    public final EObject ruleProcessings() throws RecognitionException {
        EObject current = null;

        EObject this_Details_0 = null;

        EObject this_Wizard_1 = null;

        EObject this_PropertiesView_2 = null;

        EObject this_Action_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:148:28: ( (this_Details_0= ruleDetails | this_Wizard_1= ruleWizard | this_PropertiesView_2= rulePropertiesView | this_Action_3= ruleAction ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:149:1: (this_Details_0= ruleDetails | this_Wizard_1= ruleWizard | this_PropertiesView_2= rulePropertiesView | this_Action_3= ruleAction )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:149:1: (this_Details_0= ruleDetails | this_Wizard_1= ruleWizard | this_PropertiesView_2= rulePropertiesView | this_Action_3= ruleAction )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt2=1;
                }
                break;
            case 15:
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
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:150:5: this_Details_0= ruleDetails
                    {
                     
                            newCompositeNode(grammarAccess.getProcessingsAccess().getDetailsParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDetails_in_ruleProcessings282);
                    this_Details_0=ruleDetails();

                    state._fsp--;

                     
                            current = this_Details_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:160:5: this_Wizard_1= ruleWizard
                    {
                     
                            newCompositeNode(grammarAccess.getProcessingsAccess().getWizardParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleWizard_in_ruleProcessings309);
                    this_Wizard_1=ruleWizard();

                    state._fsp--;

                     
                            current = this_Wizard_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:170:5: this_PropertiesView_2= rulePropertiesView
                    {
                     
                            newCompositeNode(grammarAccess.getProcessingsAccess().getPropertiesViewParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_rulePropertiesView_in_ruleProcessings336);
                    this_PropertiesView_2=rulePropertiesView();

                    state._fsp--;

                     
                            current = this_PropertiesView_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:180:5: this_Action_3= ruleAction
                    {
                     
                            newCompositeNode(grammarAccess.getProcessingsAccess().getActionParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAction_in_ruleProcessings363);
                    this_Action_3=ruleAction();

                    state._fsp--;

                     
                            current = this_Action_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcessings"


    // $ANTLR start "entryRulePropertiesView"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:196:1: entryRulePropertiesView returns [EObject current=null] : iv_rulePropertiesView= rulePropertiesView EOF ;
    public final EObject entryRulePropertiesView() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertiesView = null;


        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:197:2: (iv_rulePropertiesView= rulePropertiesView EOF )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:198:2: iv_rulePropertiesView= rulePropertiesView EOF
            {
             newCompositeNode(grammarAccess.getPropertiesViewRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePropertiesView_in_entryRulePropertiesView398);
            iv_rulePropertiesView=rulePropertiesView();

            state._fsp--;

             current =iv_rulePropertiesView; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePropertiesView408); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertiesView"


    // $ANTLR start "rulePropertiesView"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:205:1: rulePropertiesView returns [EObject current=null] : (otherlv_0= 'propertiesView' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' ) ;
    public final EObject rulePropertiesView() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_processings_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:208:28: ( (otherlv_0= 'propertiesView' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:209:1: (otherlv_0= 'propertiesView' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:209:1: (otherlv_0= 'propertiesView' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:209:3: otherlv_0= 'propertiesView' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_rulePropertiesView445); 

                	newLeafNode(otherlv_0, grammarAccess.getPropertiesViewAccess().getPropertiesViewKeyword_0());
                
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:213:1: ( (lv_name_1_0= ruleEString ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_STRING && LA3_0<=RULE_ID)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:214:1: (lv_name_1_0= ruleEString )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:214:1: (lv_name_1_0= ruleEString )
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:215:3: lv_name_1_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getPropertiesViewAccess().getNameEStringParserRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_rulePropertiesView466);
                    lv_name_1_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPropertiesViewRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_rulePropertiesView479); 

                	newLeafNode(otherlv_2, grammarAccess.getPropertiesViewAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:235:1: ( (lv_processings_3_0= ruleSubProcessings ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=14 && LA4_0<=18)||LA4_0==21) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:236:1: (lv_processings_3_0= ruleSubProcessings )
            	    {
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:236:1: (lv_processings_3_0= ruleSubProcessings )
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:237:3: lv_processings_3_0= ruleSubProcessings
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPropertiesViewAccess().getProcessingsSubProcessingsParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleSubProcessings_in_rulePropertiesView500);
            	    lv_processings_3_0=ruleSubProcessings();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPropertiesViewRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"processings",
            	            		lv_processings_3_0, 
            	            		"SubProcessings");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_rulePropertiesView513); 

                	newLeafNode(otherlv_4, grammarAccess.getPropertiesViewAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertiesView"


    // $ANTLR start "entryRuleWizard"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:265:1: entryRuleWizard returns [EObject current=null] : iv_ruleWizard= ruleWizard EOF ;
    public final EObject entryRuleWizard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWizard = null;


        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:266:2: (iv_ruleWizard= ruleWizard EOF )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:267:2: iv_ruleWizard= ruleWizard EOF
            {
             newCompositeNode(grammarAccess.getWizardRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleWizard_in_entryRuleWizard549);
            iv_ruleWizard=ruleWizard();

            state._fsp--;

             current =iv_ruleWizard; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWizard559); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWizard"


    // $ANTLR start "ruleWizard"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:274:1: ruleWizard returns [EObject current=null] : (otherlv_0= 'wizard' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' ) ;
    public final EObject ruleWizard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_processings_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:277:28: ( (otherlv_0= 'wizard' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:278:1: (otherlv_0= 'wizard' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:278:1: (otherlv_0= 'wizard' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:278:3: otherlv_0= 'wizard' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleWizard596); 

                	newLeafNode(otherlv_0, grammarAccess.getWizardAccess().getWizardKeyword_0());
                
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:282:1: ( (lv_name_1_0= ruleEString ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=RULE_STRING && LA5_0<=RULE_ID)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:283:1: (lv_name_1_0= ruleEString )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:283:1: (lv_name_1_0= ruleEString )
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:284:3: lv_name_1_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getWizardAccess().getNameEStringParserRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleWizard617);
                    lv_name_1_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getWizardRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleWizard630); 

                	newLeafNode(otherlv_2, grammarAccess.getWizardAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:304:1: ( (lv_processings_3_0= ruleSubProcessings ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=14 && LA6_0<=18)||LA6_0==21) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:305:1: (lv_processings_3_0= ruleSubProcessings )
            	    {
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:305:1: (lv_processings_3_0= ruleSubProcessings )
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:306:3: lv_processings_3_0= ruleSubProcessings
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getWizardAccess().getProcessingsSubProcessingsParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleSubProcessings_in_ruleWizard651);
            	    lv_processings_3_0=ruleSubProcessings();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getWizardRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"processings",
            	            		lv_processings_3_0, 
            	            		"SubProcessings");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleWizard664); 

                	newLeafNode(otherlv_4, grammarAccess.getWizardAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWizard"


    // $ANTLR start "entryRuleDetails"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:334:1: entryRuleDetails returns [EObject current=null] : iv_ruleDetails= ruleDetails EOF ;
    public final EObject entryRuleDetails() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDetails = null;


        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:335:2: (iv_ruleDetails= ruleDetails EOF )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:336:2: iv_ruleDetails= ruleDetails EOF
            {
             newCompositeNode(grammarAccess.getDetailsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDetails_in_entryRuleDetails700);
            iv_ruleDetails=ruleDetails();

            state._fsp--;

             current =iv_ruleDetails; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDetails710); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDetails"


    // $ANTLR start "ruleDetails"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:343:1: ruleDetails returns [EObject current=null] : (otherlv_0= 'detailsPage' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' ) ;
    public final EObject ruleDetails() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_processings_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:346:28: ( (otherlv_0= 'detailsPage' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:347:1: (otherlv_0= 'detailsPage' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:347:1: (otherlv_0= 'detailsPage' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:347:3: otherlv_0= 'detailsPage' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleDetails747); 

                	newLeafNode(otherlv_0, grammarAccess.getDetailsAccess().getDetailsPageKeyword_0());
                
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:351:1: ( (lv_name_1_0= ruleEString ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_ID)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:352:1: (lv_name_1_0= ruleEString )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:352:1: (lv_name_1_0= ruleEString )
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:353:3: lv_name_1_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getDetailsAccess().getNameEStringParserRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleDetails768);
                    lv_name_1_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDetailsRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleDetails781); 

                	newLeafNode(otherlv_2, grammarAccess.getDetailsAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:373:1: ( (lv_processings_3_0= ruleSubProcessings ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=14 && LA8_0<=18)||LA8_0==21) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:374:1: (lv_processings_3_0= ruleSubProcessings )
            	    {
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:374:1: (lv_processings_3_0= ruleSubProcessings )
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:375:3: lv_processings_3_0= ruleSubProcessings
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDetailsAccess().getProcessingsSubProcessingsParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleSubProcessings_in_ruleDetails802);
            	    lv_processings_3_0=ruleSubProcessings();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDetailsRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"processings",
            	            		lv_processings_3_0, 
            	            		"SubProcessings");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleDetails815); 

                	newLeafNode(otherlv_4, grammarAccess.getDetailsAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDetails"


    // $ANTLR start "entryRuleSubProcessings"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:403:1: entryRuleSubProcessings returns [EObject current=null] : iv_ruleSubProcessings= ruleSubProcessings EOF ;
    public final EObject entryRuleSubProcessings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubProcessings = null;


        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:404:2: (iv_ruleSubProcessings= ruleSubProcessings EOF )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:405:2: iv_ruleSubProcessings= ruleSubProcessings EOF
            {
             newCompositeNode(grammarAccess.getSubProcessingsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubProcessings_in_entryRuleSubProcessings851);
            iv_ruleSubProcessings=ruleSubProcessings();

            state._fsp--;

             current =iv_ruleSubProcessings; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubProcessings861); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubProcessings"


    // $ANTLR start "ruleSubProcessings"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:412:1: ruleSubProcessings returns [EObject current=null] : (this_Wizard_0= ruleWizard | this_Details_1= ruleDetails | this_PropertiesView_2= rulePropertiesView | this_Action_3= ruleAction ) ;
    public final EObject ruleSubProcessings() throws RecognitionException {
        EObject current = null;

        EObject this_Wizard_0 = null;

        EObject this_Details_1 = null;

        EObject this_PropertiesView_2 = null;

        EObject this_Action_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:415:28: ( (this_Wizard_0= ruleWizard | this_Details_1= ruleDetails | this_PropertiesView_2= rulePropertiesView | this_Action_3= ruleAction ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:416:1: (this_Wizard_0= ruleWizard | this_Details_1= ruleDetails | this_PropertiesView_2= rulePropertiesView | this_Action_3= ruleAction )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:416:1: (this_Wizard_0= ruleWizard | this_Details_1= ruleDetails | this_PropertiesView_2= rulePropertiesView | this_Action_3= ruleAction )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt9=1;
                }
                break;
            case 16:
                {
                alt9=2;
                }
                break;
            case 14:
                {
                alt9=3;
                }
                break;
            case 17:
            case 18:
            case 21:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:417:5: this_Wizard_0= ruleWizard
                    {
                     
                            newCompositeNode(grammarAccess.getSubProcessingsAccess().getWizardParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleWizard_in_ruleSubProcessings908);
                    this_Wizard_0=ruleWizard();

                    state._fsp--;

                     
                            current = this_Wizard_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:427:5: this_Details_1= ruleDetails
                    {
                     
                            newCompositeNode(grammarAccess.getSubProcessingsAccess().getDetailsParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDetails_in_ruleSubProcessings935);
                    this_Details_1=ruleDetails();

                    state._fsp--;

                     
                            current = this_Details_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:437:5: this_PropertiesView_2= rulePropertiesView
                    {
                     
                            newCompositeNode(grammarAccess.getSubProcessingsAccess().getPropertiesViewParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_rulePropertiesView_in_ruleSubProcessings962);
                    this_PropertiesView_2=rulePropertiesView();

                    state._fsp--;

                     
                            current = this_PropertiesView_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:447:5: this_Action_3= ruleAction
                    {
                     
                            newCompositeNode(grammarAccess.getSubProcessingsAccess().getActionParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAction_in_ruleSubProcessings989);
                    this_Action_3=ruleAction();

                    state._fsp--;

                     
                            current = this_Action_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubProcessings"


    // $ANTLR start "entryRuleAction"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:463:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:464:2: (iv_ruleAction= ruleAction EOF )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:465:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAction_in_entryRuleAction1024);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAction1034); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:472:1: ruleAction returns [EObject current=null] : (this_EclipseAction_0= ruleEclipseAction | this_EEFAction_1= ruleEEFAction ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        EObject this_EclipseAction_0 = null;

        EObject this_EEFAction_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:475:28: ( (this_EclipseAction_0= ruleEclipseAction | this_EEFAction_1= ruleEEFAction ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:476:1: (this_EclipseAction_0= ruleEclipseAction | this_EEFAction_1= ruleEEFAction )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:476:1: (this_EclipseAction_0= ruleEclipseAction | this_EEFAction_1= ruleEEFAction )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=17 && LA10_0<=18)) ) {
                alt10=1;
            }
            else if ( (LA10_0==21) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:477:5: this_EclipseAction_0= ruleEclipseAction
                    {
                     
                            newCompositeNode(grammarAccess.getActionAccess().getEclipseActionParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEclipseAction_in_ruleAction1081);
                    this_EclipseAction_0=ruleEclipseAction();

                    state._fsp--;

                     
                            current = this_EclipseAction_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:487:5: this_EEFAction_1= ruleEEFAction
                    {
                     
                            newCompositeNode(grammarAccess.getActionAccess().getEEFActionParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEEFAction_in_ruleAction1108);
                    this_EEFAction_1=ruleEEFAction();

                    state._fsp--;

                     
                            current = this_EEFAction_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleEclipseAction"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:503:1: entryRuleEclipseAction returns [EObject current=null] : iv_ruleEclipseAction= ruleEclipseAction EOF ;
    public final EObject entryRuleEclipseAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEclipseAction = null;


        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:504:2: (iv_ruleEclipseAction= ruleEclipseAction EOF )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:505:2: iv_ruleEclipseAction= ruleEclipseAction EOF
            {
             newCompositeNode(grammarAccess.getEclipseActionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEclipseAction_in_entryRuleEclipseAction1143);
            iv_ruleEclipseAction=ruleEclipseAction();

            state._fsp--;

             current =iv_ruleEclipseAction; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEclipseAction1153); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEclipseAction"


    // $ANTLR start "ruleEclipseAction"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:512:1: ruleEclipseAction returns [EObject current=null] : (this_CreateProject_0= ruleCreateProject | this_CreateModel_1= ruleCreateModel ) ;
    public final EObject ruleEclipseAction() throws RecognitionException {
        EObject current = null;

        EObject this_CreateProject_0 = null;

        EObject this_CreateModel_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:515:28: ( (this_CreateProject_0= ruleCreateProject | this_CreateModel_1= ruleCreateModel ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:516:1: (this_CreateProject_0= ruleCreateProject | this_CreateModel_1= ruleCreateModel )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:516:1: (this_CreateProject_0= ruleCreateProject | this_CreateModel_1= ruleCreateModel )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==17) ) {
                alt11=1;
            }
            else if ( (LA11_0==18) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:517:5: this_CreateProject_0= ruleCreateProject
                    {
                     
                            newCompositeNode(grammarAccess.getEclipseActionAccess().getCreateProjectParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCreateProject_in_ruleEclipseAction1200);
                    this_CreateProject_0=ruleCreateProject();

                    state._fsp--;

                     
                            current = this_CreateProject_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:527:5: this_CreateModel_1= ruleCreateModel
                    {
                     
                            newCompositeNode(grammarAccess.getEclipseActionAccess().getCreateModelParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCreateModel_in_ruleEclipseAction1227);
                    this_CreateModel_1=ruleCreateModel();

                    state._fsp--;

                     
                            current = this_CreateModel_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEclipseAction"


    // $ANTLR start "entryRuleCreateProject"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:543:1: entryRuleCreateProject returns [EObject current=null] : iv_ruleCreateProject= ruleCreateProject EOF ;
    public final EObject entryRuleCreateProject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreateProject = null;


        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:544:2: (iv_ruleCreateProject= ruleCreateProject EOF )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:545:2: iv_ruleCreateProject= ruleCreateProject EOF
            {
             newCompositeNode(grammarAccess.getCreateProjectRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCreateProject_in_entryRuleCreateProject1262);
            iv_ruleCreateProject=ruleCreateProject();

            state._fsp--;

             current =iv_ruleCreateProject; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCreateProject1272); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCreateProject"


    // $ANTLR start "ruleCreateProject"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:552:1: ruleCreateProject returns [EObject current=null] : (otherlv_0= 'create project ' ( (lv_projectName_1_0= ruleEString ) ) ) ;
    public final EObject ruleCreateProject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_projectName_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:555:28: ( (otherlv_0= 'create project ' ( (lv_projectName_1_0= ruleEString ) ) ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:556:1: (otherlv_0= 'create project ' ( (lv_projectName_1_0= ruleEString ) ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:556:1: (otherlv_0= 'create project ' ( (lv_projectName_1_0= ruleEString ) ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:556:3: otherlv_0= 'create project ' ( (lv_projectName_1_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleCreateProject1309); 

                	newLeafNode(otherlv_0, grammarAccess.getCreateProjectAccess().getCreateProjectKeyword_0());
                
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:560:1: ( (lv_projectName_1_0= ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:561:1: (lv_projectName_1_0= ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:561:1: (lv_projectName_1_0= ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:562:3: lv_projectName_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getCreateProjectAccess().getProjectNameEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleCreateProject1330);
            lv_projectName_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCreateProjectRule());
            	        }
                   		set(
                   			current, 
                   			"projectName",
                    		lv_projectName_1_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCreateProject"


    // $ANTLR start "entryRuleCreateModel"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:586:1: entryRuleCreateModel returns [EObject current=null] : iv_ruleCreateModel= ruleCreateModel EOF ;
    public final EObject entryRuleCreateModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreateModel = null;


        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:587:2: (iv_ruleCreateModel= ruleCreateModel EOF )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:588:2: iv_ruleCreateModel= ruleCreateModel EOF
            {
             newCompositeNode(grammarAccess.getCreateModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCreateModel_in_entryRuleCreateModel1366);
            iv_ruleCreateModel=ruleCreateModel();

            state._fsp--;

             current =iv_ruleCreateModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCreateModel1376); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCreateModel"


    // $ANTLR start "ruleCreateModel"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:595:1: ruleCreateModel returns [EObject current=null] : (otherlv_0= 'create model ' ( (lv_modelName_1_0= ruleEString ) ) otherlv_2= ' at ' ( (lv_path_3_0= ruleEString ) ) otherlv_4= ' with RootType ' ( (lv_rootURI_5_0= ruleEString ) ) ) ;
    public final EObject ruleCreateModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_modelName_1_0 = null;

        AntlrDatatypeRuleToken lv_path_3_0 = null;

        AntlrDatatypeRuleToken lv_rootURI_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:598:28: ( (otherlv_0= 'create model ' ( (lv_modelName_1_0= ruleEString ) ) otherlv_2= ' at ' ( (lv_path_3_0= ruleEString ) ) otherlv_4= ' with RootType ' ( (lv_rootURI_5_0= ruleEString ) ) ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:599:1: (otherlv_0= 'create model ' ( (lv_modelName_1_0= ruleEString ) ) otherlv_2= ' at ' ( (lv_path_3_0= ruleEString ) ) otherlv_4= ' with RootType ' ( (lv_rootURI_5_0= ruleEString ) ) )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:599:1: (otherlv_0= 'create model ' ( (lv_modelName_1_0= ruleEString ) ) otherlv_2= ' at ' ( (lv_path_3_0= ruleEString ) ) otherlv_4= ' with RootType ' ( (lv_rootURI_5_0= ruleEString ) ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:599:3: otherlv_0= 'create model ' ( (lv_modelName_1_0= ruleEString ) ) otherlv_2= ' at ' ( (lv_path_3_0= ruleEString ) ) otherlv_4= ' with RootType ' ( (lv_rootURI_5_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleCreateModel1413); 

                	newLeafNode(otherlv_0, grammarAccess.getCreateModelAccess().getCreateModelKeyword_0());
                
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:603:1: ( (lv_modelName_1_0= ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:604:1: (lv_modelName_1_0= ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:604:1: (lv_modelName_1_0= ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:605:3: lv_modelName_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getCreateModelAccess().getModelNameEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleCreateModel1434);
            lv_modelName_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCreateModelRule());
            	        }
                   		set(
                   			current, 
                   			"modelName",
                    		lv_modelName_1_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleCreateModel1446); 

                	newLeafNode(otherlv_2, grammarAccess.getCreateModelAccess().getAtKeyword_2());
                
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:625:1: ( (lv_path_3_0= ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:626:1: (lv_path_3_0= ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:626:1: (lv_path_3_0= ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:627:3: lv_path_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getCreateModelAccess().getPathEStringParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleCreateModel1467);
            lv_path_3_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCreateModelRule());
            	        }
                   		set(
                   			current, 
                   			"path",
                    		lv_path_3_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleCreateModel1479); 

                	newLeafNode(otherlv_4, grammarAccess.getCreateModelAccess().getWithRootTypeKeyword_4());
                
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:647:1: ( (lv_rootURI_5_0= ruleEString ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:648:1: (lv_rootURI_5_0= ruleEString )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:648:1: (lv_rootURI_5_0= ruleEString )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:649:3: lv_rootURI_5_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getCreateModelAccess().getRootURIEStringParserRuleCall_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleCreateModel1500);
            lv_rootURI_5_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCreateModelRule());
            	        }
                   		set(
                   			current, 
                   			"rootURI",
                    		lv_rootURI_5_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCreateModel"


    // $ANTLR start "entryRuleEEFAction"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:673:1: entryRuleEEFAction returns [EObject current=null] : iv_ruleEEFAction= ruleEEFAction EOF ;
    public final EObject entryRuleEEFAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEEFAction = null;


        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:674:2: (iv_ruleEEFAction= ruleEEFAction EOF )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:675:2: iv_ruleEEFAction= ruleEEFAction EOF
            {
             newCompositeNode(grammarAccess.getEEFActionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEEFAction_in_entryRuleEEFAction1536);
            iv_ruleEEFAction=ruleEEFAction();

            state._fsp--;

             current =iv_ruleEEFAction; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEEFAction1546); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEEFAction"


    // $ANTLR start "ruleEEFAction"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:682:1: ruleEEFAction returns [EObject current=null] : this_Check_0= ruleCheck ;
    public final EObject ruleEEFAction() throws RecognitionException {
        EObject current = null;

        EObject this_Check_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:685:28: (this_Check_0= ruleCheck )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:687:5: this_Check_0= ruleCheck
            {
             
                    newCompositeNode(grammarAccess.getEEFActionAccess().getCheckParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleCheck_in_ruleEEFAction1592);
            this_Check_0=ruleCheck();

            state._fsp--;

             
                    current = this_Check_0; 
                    afterParserOrEnumRuleCall();
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEEFAction"


    // $ANTLR start "entryRuleCheck"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:703:1: entryRuleCheck returns [EObject current=null] : iv_ruleCheck= ruleCheck EOF ;
    public final EObject entryRuleCheck() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCheck = null;


        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:704:2: (iv_ruleCheck= ruleCheck EOF )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:705:2: iv_ruleCheck= ruleCheck EOF
            {
             newCompositeNode(grammarAccess.getCheckRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCheck_in_entryRuleCheck1626);
            iv_ruleCheck=ruleCheck();

            state._fsp--;

             current =iv_ruleCheck; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCheck1636); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCheck"


    // $ANTLR start "ruleCheck"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:712:1: ruleCheck returns [EObject current=null] : (otherlv_0= 'check' () ) ;
    public final EObject ruleCheck() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:715:28: ( (otherlv_0= 'check' () ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:716:1: (otherlv_0= 'check' () )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:716:1: (otherlv_0= 'check' () )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:716:3: otherlv_0= 'check' ()
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleCheck1673); 

                	newLeafNode(otherlv_0, grammarAccess.getCheckAccess().getCheckKeyword_0());
                
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:720:1: ()
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:721:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCheckAccess().getCheckAction_1(),
                        current);
                

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCheck"


    // $ANTLR start "entryRuleEString"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:734:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:735:2: (iv_ruleEString= ruleEString EOF )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:736:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString1719);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString1730); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:743:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:746:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:747:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:747:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_STRING) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:747:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString1770); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:755:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString1796); 

                    		current.merge(this_ID_1);
                        
                     
                        newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleScenario_in_entryRuleScenario75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleScenario122 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleScenario143 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleScenario155 = new BitSet(new long[]{0x000000000027E000L});
        public static final BitSet FOLLOW_ruleProcessings_in_ruleScenario176 = new BitSet(new long[]{0x000000000027E000L});
        public static final BitSet FOLLOW_13_in_ruleScenario189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProcessings_in_entryRuleProcessings225 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProcessings235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDetails_in_ruleProcessings282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWizard_in_ruleProcessings309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertiesView_in_ruleProcessings336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_ruleProcessings363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertiesView_in_entryRulePropertiesView398 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePropertiesView408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rulePropertiesView445 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_ruleEString_in_rulePropertiesView466 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_rulePropertiesView479 = new BitSet(new long[]{0x000000000027E000L});
        public static final BitSet FOLLOW_ruleSubProcessings_in_rulePropertiesView500 = new BitSet(new long[]{0x000000000027E000L});
        public static final BitSet FOLLOW_13_in_rulePropertiesView513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWizard_in_entryRuleWizard549 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWizard559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleWizard596 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleWizard617 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleWizard630 = new BitSet(new long[]{0x000000000027E000L});
        public static final BitSet FOLLOW_ruleSubProcessings_in_ruleWizard651 = new BitSet(new long[]{0x000000000027E000L});
        public static final BitSet FOLLOW_13_in_ruleWizard664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDetails_in_entryRuleDetails700 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDetails710 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleDetails747 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleDetails768 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleDetails781 = new BitSet(new long[]{0x000000000027E000L});
        public static final BitSet FOLLOW_ruleSubProcessings_in_ruleDetails802 = new BitSet(new long[]{0x000000000027E000L});
        public static final BitSet FOLLOW_13_in_ruleDetails815 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubProcessings_in_entryRuleSubProcessings851 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubProcessings861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWizard_in_ruleSubProcessings908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDetails_in_ruleSubProcessings935 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertiesView_in_ruleSubProcessings962 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_ruleSubProcessings989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_entryRuleAction1024 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAction1034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEclipseAction_in_ruleAction1081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEFAction_in_ruleAction1108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEclipseAction_in_entryRuleEclipseAction1143 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEclipseAction1153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateProject_in_ruleEclipseAction1200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateModel_in_ruleEclipseAction1227 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateProject_in_entryRuleCreateProject1262 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCreateProject1272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleCreateProject1309 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleCreateProject1330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateModel_in_entryRuleCreateModel1366 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCreateModel1376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleCreateModel1413 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleCreateModel1434 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleCreateModel1446 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleCreateModel1467 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleCreateModel1479 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleCreateModel1500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEFAction_in_entryRuleEEFAction1536 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEEFAction1546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCheck_in_ruleEEFAction1592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCheck_in_entryRuleCheck1626 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCheck1636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleCheck1673 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString1719 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString1730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString1770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEString1796 = new BitSet(new long[]{0x0000000000000002L});
    }


}