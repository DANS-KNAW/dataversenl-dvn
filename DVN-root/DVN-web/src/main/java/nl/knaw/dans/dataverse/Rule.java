/*
   Copyright (C) 2005-2012, by the President and Fellows of Harvard College.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

   Dataverse Network - A web application to share, preserve and analyze research data.
   Developed at the Institute for Quantitative Social Science, Harvard University.
   Version 3.0.
*/
/*
 * Role.java
 *
 * Created on July 28, 2006, 2:18 PM
 *
 */
package nl.knaw.dans.dataverse;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Eko Indarto
 */
@Entity
public class Rule implements java.io.Serializable  {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3345859427256966912L;
	private String name;
	private String description;
    
    
    /** Creates a new instance of Role */
    public Rule() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy="rule", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private Collection<RuleCondition> ruleCondition;
    
    @OneToMany(mappedBy="rule", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private Collection<RuleGoal> ruleGoal;

    public Collection<RuleCondition> getRuleCondition() {
		return ruleCondition;
	}

	public void setRuleCondition(Collection<RuleCondition> ruleCondition) {
		this.ruleCondition = ruleCondition;
	}

	public Collection<RuleGoal> getRuleGoal() {
		return ruleGoal;
	}

	public void setRuleGoal(Collection<RuleGoal> ruleGoal) {
		this.ruleGoal = ruleGoal;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
   

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rule)) {
            return false;
        }
        Rule other = (Rule)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }                
}
