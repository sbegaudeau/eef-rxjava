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
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:76:1: ruleScenario returns [EObject current=null] : (otherlv_0= 'scenario' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' ( (lv_processings_3_0= ruleEEFProcessings ) )* otherlv_4= '}' ) ;
    public final EObject ruleScenario() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_processings_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:79:28: ( (otherlv_0= 'scenario' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' ( (lv_processings_3_0= ruleEEFProcessings ) )* otherlv_4= '}' ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:80:1: (otherlv_0= 'scenario' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' ( (lv_processings_3_0= ruleEEFProcessings ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:80:1: (otherlv_0= 'scenario' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' ( (lv_processings_3_0= ruleEEFProcessings ) )* otherlv_4= '}' )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:80:3: otherlv_0= 'scenario' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' ( (lv_processings_3_0= ruleEEFProcessings ) )* otherlv_4= '}'
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
                
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:106:1: ( (lv_processings_3_0= ruleEEFProcessings ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=14 && LA1_0<=16)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:107:1: (lv_processings_3_0= ruleEEFProcessings )
            	    {
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:107:1: (lv_processings_3_0= ruleEEFProcessings )
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:108:3: lv_processings_3_0= ruleEEFProcessings
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScenarioAccess().getProcessingsEEFProcessingsParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEEFProcessings_in_ruleScenario176);
            	    lv_processings_3_0=ruleEEFProcessings();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScenarioRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"processings",
            	            		lv_processings_3_0, 
            	            		"EEFProcessings");
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


    // $ANTLR start "entryRuleEEFProcessings"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:136:1: entryRuleEEFProcessings returns [EObject current=null] : iv_ruleEEFProcessings= ruleEEFProcessings EOF ;
    public final EObject entryRuleEEFProcessings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEEFProcessings = null;


        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:137:2: (iv_ruleEEFProcessings= ruleEEFProcessings EOF )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:138:2: iv_ruleEEFProcessings= ruleEEFProcessings EOF
            {
             newCompositeNode(grammarAccess.getEEFProcessingsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEEFProcessings_in_entryRuleEEFProcessings225);
            iv_ruleEEFProcessings=ruleEEFProcessings();

            state._fsp--;

             current =iv_ruleEEFProcessings; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEEFProcessings235); 

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
    // $ANTLR end "entryRuleEEFProcessings"


    // $ANTLR start "ruleEEFProcessings"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:145:1: ruleEEFProcessings returns [EObject current=null] : (this_Details_0= ruleDetails | this_Wizard_1= ruleWizard | this_PropertiesView_2= rulePropertiesView ) ;
    public final EObject ruleEEFProcessings() throws RecognitionException {
        EObject current = null;

        EObject this_Details_0 = null;

        EObject this_Wizard_1 = null;

        EObject this_PropertiesView_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:148:28: ( (this_Details_0= ruleDetails | this_Wizard_1= ruleWizard | this_PropertiesView_2= rulePropertiesView ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:149:1: (this_Details_0= ruleDetails | this_Wizard_1= ruleWizard | this_PropertiesView_2= rulePropertiesView )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:149:1: (this_Details_0= ruleDetails | this_Wizard_1= ruleWizard | this_PropertiesView_2= rulePropertiesView )
            int alt2=3;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:150:5: this_Details_0= ruleDetails
                    {
                     
                            newCompositeNode(grammarAccess.getEEFProcessingsAccess().getDetailsParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDetails_in_ruleEEFProcessings282);
                    this_Details_0=ruleDetails();

                    state._fsp--;

                     
                            current = this_Details_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:160:5: this_Wizard_1= ruleWizard
                    {
                     
                            newCompositeNode(grammarAccess.getEEFProcessingsAccess().getWizardParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleWizard_in_ruleEEFProcessings309);
                    this_Wizard_1=ruleWizard();

                    state._fsp--;

                     
                            current = this_Wizard_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:170:5: this_PropertiesView_2= rulePropertiesView
                    {
                     
                            newCompositeNode(grammarAccess.getEEFProcessingsAccess().getPropertiesViewParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_rulePropertiesView_in_ruleEEFProcessings336);
                    this_PropertiesView_2=rulePropertiesView();

                    state._fsp--;

                     
                            current = this_PropertiesView_2; 
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
    // $ANTLR end "ruleEEFProcessings"


    // $ANTLR start "entryRulePropertiesView"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:186:1: entryRulePropertiesView returns [EObject current=null] : iv_rulePropertiesView= rulePropertiesView EOF ;
    public final EObject entryRulePropertiesView() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertiesView = null;


        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:187:2: (iv_rulePropertiesView= rulePropertiesView EOF )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:188:2: iv_rulePropertiesView= rulePropertiesView EOF
            {
             newCompositeNode(grammarAccess.getPropertiesViewRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePropertiesView_in_entryRulePropertiesView371);
            iv_rulePropertiesView=rulePropertiesView();

            state._fsp--;

             current =iv_rulePropertiesView; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePropertiesView381); 

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
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:195:1: rulePropertiesView returns [EObject current=null] : (otherlv_0= 'propertiesView' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' ) ;
    public final EObject rulePropertiesView() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_processings_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:198:28: ( (otherlv_0= 'propertiesView' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:199:1: (otherlv_0= 'propertiesView' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:199:1: (otherlv_0= 'propertiesView' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:199:3: otherlv_0= 'propertiesView' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_rulePropertiesView418); 

                	newLeafNode(otherlv_0, grammarAccess.getPropertiesViewAccess().getPropertiesViewKeyword_0());
                
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:203:1: ( (lv_name_1_0= ruleEString ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_STRING && LA3_0<=RULE_ID)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:204:1: (lv_name_1_0= ruleEString )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:204:1: (lv_name_1_0= ruleEString )
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:205:3: lv_name_1_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getPropertiesViewAccess().getNameEStringParserRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_rulePropertiesView439);
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

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_rulePropertiesView452); 

                	newLeafNode(otherlv_2, grammarAccess.getPropertiesViewAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:225:1: ( (lv_processings_3_0= ruleSubProcessings ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:226:1: (lv_processings_3_0= ruleSubProcessings )
            	    {
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:226:1: (lv_processings_3_0= ruleSubProcessings )
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:227:3: lv_processings_3_0= ruleSubProcessings
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPropertiesViewAccess().getProcessingsSubProcessingsParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleSubProcessings_in_rulePropertiesView473);
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

            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_rulePropertiesView486); 

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
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:255:1: entryRuleWizard returns [EObject current=null] : iv_ruleWizard= ruleWizard EOF ;
    public final EObject entryRuleWizard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWizard = null;


        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:256:2: (iv_ruleWizard= ruleWizard EOF )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:257:2: iv_ruleWizard= ruleWizard EOF
            {
             newCompositeNode(grammarAccess.getWizardRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleWizard_in_entryRuleWizard522);
            iv_ruleWizard=ruleWizard();

            state._fsp--;

             current =iv_ruleWizard; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWizard532); 

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
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:264:1: ruleWizard returns [EObject current=null] : (otherlv_0= 'wizard' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' ) ;
    public final EObject ruleWizard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_processings_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:267:28: ( (otherlv_0= 'wizard' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:268:1: (otherlv_0= 'wizard' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:268:1: (otherlv_0= 'wizard' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:268:3: otherlv_0= 'wizard' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleWizard569); 

                	newLeafNode(otherlv_0, grammarAccess.getWizardAccess().getWizardKeyword_0());
                
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:272:1: ( (lv_name_1_0= ruleEString ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=RULE_STRING && LA5_0<=RULE_ID)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:273:1: (lv_name_1_0= ruleEString )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:273:1: (lv_name_1_0= ruleEString )
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:274:3: lv_name_1_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getWizardAccess().getNameEStringParserRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleWizard590);
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

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleWizard603); 

                	newLeafNode(otherlv_2, grammarAccess.getWizardAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:294:1: ( (lv_processings_3_0= ruleSubProcessings ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==15) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:295:1: (lv_processings_3_0= ruleSubProcessings )
            	    {
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:295:1: (lv_processings_3_0= ruleSubProcessings )
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:296:3: lv_processings_3_0= ruleSubProcessings
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getWizardAccess().getProcessingsSubProcessingsParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleSubProcessings_in_ruleWizard624);
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

            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleWizard637); 

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
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:324:1: entryRuleDetails returns [EObject current=null] : iv_ruleDetails= ruleDetails EOF ;
    public final EObject entryRuleDetails() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDetails = null;


        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:325:2: (iv_ruleDetails= ruleDetails EOF )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:326:2: iv_ruleDetails= ruleDetails EOF
            {
             newCompositeNode(grammarAccess.getDetailsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDetails_in_entryRuleDetails673);
            iv_ruleDetails=ruleDetails();

            state._fsp--;

             current =iv_ruleDetails; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDetails683); 

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
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:333:1: ruleDetails returns [EObject current=null] : (otherlv_0= 'detailsPage' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' ) ;
    public final EObject ruleDetails() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_processings_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:336:28: ( (otherlv_0= 'detailsPage' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:337:1: (otherlv_0= 'detailsPage' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:337:1: (otherlv_0= 'detailsPage' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}' )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:337:3: otherlv_0= 'detailsPage' ( (lv_name_1_0= ruleEString ) )? otherlv_2= '{' ( (lv_processings_3_0= ruleSubProcessings ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleDetails720); 

                	newLeafNode(otherlv_0, grammarAccess.getDetailsAccess().getDetailsPageKeyword_0());
                
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:341:1: ( (lv_name_1_0= ruleEString ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_ID)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:342:1: (lv_name_1_0= ruleEString )
                    {
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:342:1: (lv_name_1_0= ruleEString )
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:343:3: lv_name_1_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getDetailsAccess().getNameEStringParserRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleDetails741);
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

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleDetails754); 

                	newLeafNode(otherlv_2, grammarAccess.getDetailsAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:363:1: ( (lv_processings_3_0= ruleSubProcessings ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==15) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:364:1: (lv_processings_3_0= ruleSubProcessings )
            	    {
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:364:1: (lv_processings_3_0= ruleSubProcessings )
            	    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:365:3: lv_processings_3_0= ruleSubProcessings
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDetailsAccess().getProcessingsSubProcessingsParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleSubProcessings_in_ruleDetails775);
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

            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleDetails788); 

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
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:393:1: entryRuleSubProcessings returns [EObject current=null] : iv_ruleSubProcessings= ruleSubProcessings EOF ;
    public final EObject entryRuleSubProcessings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubProcessings = null;


        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:394:2: (iv_ruleSubProcessings= ruleSubProcessings EOF )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:395:2: iv_ruleSubProcessings= ruleSubProcessings EOF
            {
             newCompositeNode(grammarAccess.getSubProcessingsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubProcessings_in_entryRuleSubProcessings824);
            iv_ruleSubProcessings=ruleSubProcessings();

            state._fsp--;

             current =iv_ruleSubProcessings; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubProcessings834); 

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
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:402:1: ruleSubProcessings returns [EObject current=null] : this_Wizard_0= ruleWizard ;
    public final EObject ruleSubProcessings() throws RecognitionException {
        EObject current = null;

        EObject this_Wizard_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:405:28: (this_Wizard_0= ruleWizard )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:407:5: this_Wizard_0= ruleWizard
            {
             
                    newCompositeNode(grammarAccess.getSubProcessingsAccess().getWizardParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleWizard_in_ruleSubProcessings880);
            this_Wizard_0=ruleWizard();

            state._fsp--;

             
                    current = this_Wizard_0; 
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
    // $ANTLR end "ruleSubProcessings"


    // $ANTLR start "entryRuleEString"
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:423:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:424:2: (iv_ruleEString= ruleEString EOF )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:425:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString915);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString926); 

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
    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:432:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:435:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:436:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:436:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_STRING) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:436:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString966); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.modelingbot.xtext/src-gen/org/eclipse/emf/eef/parser/antlr/internal/InternalModelingBot.g:444:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString992); 

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
        public static final BitSet FOLLOW_12_in_ruleScenario155 = new BitSet(new long[]{0x000000000001E000L});
        public static final BitSet FOLLOW_ruleEEFProcessings_in_ruleScenario176 = new BitSet(new long[]{0x000000000001E000L});
        public static final BitSet FOLLOW_13_in_ruleScenario189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEFProcessings_in_entryRuleEEFProcessings225 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEEFProcessings235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDetails_in_ruleEEFProcessings282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWizard_in_ruleEEFProcessings309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertiesView_in_ruleEEFProcessings336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertiesView_in_entryRulePropertiesView371 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePropertiesView381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rulePropertiesView418 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_ruleEString_in_rulePropertiesView439 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_rulePropertiesView452 = new BitSet(new long[]{0x000000000000A000L});
        public static final BitSet FOLLOW_ruleSubProcessings_in_rulePropertiesView473 = new BitSet(new long[]{0x000000000000A000L});
        public static final BitSet FOLLOW_13_in_rulePropertiesView486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWizard_in_entryRuleWizard522 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWizard532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleWizard569 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleWizard590 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleWizard603 = new BitSet(new long[]{0x000000000000A000L});
        public static final BitSet FOLLOW_ruleSubProcessings_in_ruleWizard624 = new BitSet(new long[]{0x000000000000A000L});
        public static final BitSet FOLLOW_13_in_ruleWizard637 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDetails_in_entryRuleDetails673 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDetails683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleDetails720 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleDetails741 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleDetails754 = new BitSet(new long[]{0x000000000000A000L});
        public static final BitSet FOLLOW_ruleSubProcessings_in_ruleDetails775 = new BitSet(new long[]{0x000000000000A000L});
        public static final BitSet FOLLOW_13_in_ruleDetails788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubProcessings_in_entryRuleSubProcessings824 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubProcessings834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWizard_in_ruleSubProcessings880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString915 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEString992 = new BitSet(new long[]{0x0000000000000002L});
    }


}